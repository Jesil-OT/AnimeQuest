package com.jesil.animequest.anime.data.networking

import com.jesil.animequest.anime.data.mapper.toAnime
import com.jesil.animequest.anime.data.networking.dto.AnimeResponseDto
import com.jesil.animequest.anime.domain.Anime
import com.jesil.animequest.anime.domain.AnimeDataSource
import com.jesil.animequest.core.data.networking.constructUrl
import com.jesil.animequest.core.data.networking.safeCall
import com.jesil.animequest.core.domain.utils.NetworkError
import com.jesil.animequest.core.domain.utils.QueryConstants.MOVIE_ANIME
import com.jesil.animequest.core.domain.utils.QueryConstants.POPULAR_ANIME
import com.jesil.animequest.core.domain.utils.QueryConstants.SPECIAL_ANIME
import com.jesil.animequest.core.domain.utils.QueryConstants.TOP_ANIME
import com.jesil.animequest.core.domain.utils.Result
import com.jesil.animequest.core.domain.utils.map
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class RemoteAnimeDataSource(
    private val httpClient: HttpClient
) : AnimeDataSource {

    override suspend fun getTopAnime(): Result<List<Anime>, NetworkError>
        = safeCall<AnimeResponseDto> {
            httpClient.get(
                urlString = constructUrl("/anime/ranking")
            ){
                parameter("ranking_type", TOP_ANIME)
            }
        }.map { response ->
            response.data.map {it.toAnime()}
        }

    override suspend fun getPopularAnime(): Result<List<Anime>, NetworkError>
        = safeCall<AnimeResponseDto> {
            httpClient.get(
                urlString = constructUrl("/anime/ranking")
            ) {
                parameter("ranking_type", POPULAR_ANIME)
            }
        }.map { response ->
            response.data.map { it.toAnime() }
        }

    override suspend fun getMovieAnime(): Result<List<Anime>, NetworkError>
       = safeCall<AnimeResponseDto> {
            httpClient.get(
                urlString = constructUrl("/anime/ranking")
            ) {
                parameter("ranking_type", MOVIE_ANIME)
            }
        }.map { response ->
            response.data.map { it.toAnime() }
        }

    override suspend fun getSpecialAnime(): Result<List<Anime>, NetworkError> =
        safeCall<AnimeResponseDto> {
            httpClient.get(
                urlString = constructUrl("/anime/ranking")
            ) {
                parameter("ranking_type", SPECIAL_ANIME)
            }
        }.map { response ->
            response.data.map { it.toAnime() }
        }
}