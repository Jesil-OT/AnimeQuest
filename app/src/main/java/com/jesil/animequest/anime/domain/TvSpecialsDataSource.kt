package com.jesil.animequest.anime.domain

import com.jesil.animequest.core.domain.utils.NetworkError
import com.jesil.animequest.core.domain.utils.Result

interface TvSpecialsDataSource {
    suspend fun getTvSpecialAnime(): Result<List<Anime>, NetworkError>
}