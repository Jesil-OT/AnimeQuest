package com.jesil.animequest.anime.domain

import com.jesil.animequest.core.domain.utils.NetworkError
import com.jesil.animequest.core.domain.utils.Result

interface UpcomingDataSource {
   suspend fun getUpComingAnime(): Result<List<Anime>, NetworkError>
}