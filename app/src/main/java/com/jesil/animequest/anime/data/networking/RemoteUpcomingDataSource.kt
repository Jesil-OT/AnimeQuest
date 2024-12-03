package com.jesil.animequest.anime.data.networking

import com.jesil.animequest.anime.data.mapper.toAnime
import com.jesil.animequest.anime.data.networking.dto.AnimeResponseDto
import com.jesil.animequest.anime.domain.Anime
import com.jesil.animequest.anime.domain.UpcomingDataSource
import com.jesil.animequest.core.data.networking.constructUrl
import com.jesil.animequest.core.data.networking.safeCall
import com.jesil.animequest.core.domain.utils.NetworkError
import com.jesil.animequest.core.domain.utils.QueryConstants.RANKING_ANIME_ENDPOINT
import com.jesil.animequest.core.domain.utils.QueryConstants.UPCOMING_ANIME
import com.jesil.animequest.core.domain.utils.Result
import com.jesil.animequest.core.domain.utils.map
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RemoteUpcomingDataSource(
    private val httpClient: HttpClient
): UpcomingDataSource {
    override suspend fun getUpComingAnime(): Result<List<Anime>, NetworkError> =
        withContext(Dispatchers.IO) {
            safeCall<AnimeResponseDto> {
                httpClient.get(
                    urlString = constructUrl(url = RANKING_ANIME_ENDPOINT)
                ) {
                    parameter("ranking_type", UPCOMING_ANIME)
                }
            }.map { response ->
                response.data.map { it.toAnime() }
            }
        }
}