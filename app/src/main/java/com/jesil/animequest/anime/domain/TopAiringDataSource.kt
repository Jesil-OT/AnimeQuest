package com.jesil.animequest.anime.domain

import com.jesil.animequest.core.domain.utils.NetworkError
import com.jesil.animequest.core.domain.utils.Result

interface TopAiringDataSource {
    suspend fun getTopAiringAnime(): Result<List<Anime>,  NetworkError>
}