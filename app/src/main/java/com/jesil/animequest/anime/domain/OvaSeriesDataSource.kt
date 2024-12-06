package com.jesil.animequest.anime.domain

import com.jesil.animequest.core.domain.utils.NetworkError
import com.jesil.animequest.core.domain.utils.Result

interface OvaSeriesDataSource {
    suspend fun getOvaSeries(): Result<List<Anime>, NetworkError>
}