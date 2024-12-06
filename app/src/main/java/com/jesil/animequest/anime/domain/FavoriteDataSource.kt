package com.jesil.animequest.anime.domain

import com.jesil.animequest.core.domain.utils.NetworkError
import com.jesil.animequest.core.domain.utils.Result

interface FavoriteDataSource {
    suspend fun getFavoriteAnime(): Result<List<Anime>, NetworkError>
}