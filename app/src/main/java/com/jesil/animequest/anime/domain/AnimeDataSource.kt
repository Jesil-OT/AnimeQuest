package com.jesil.animequest.anime.domain

import com.jesil.animequest.core.domain.utils.NetworkError
import com.jesil.animequest.core.domain.utils.Result

interface AnimeDataSource {
    suspend fun getTopAnime(): Result<List<Anime>, NetworkError>
    suspend fun getPopularAnime(): Result<List<Anime>, NetworkError>
    suspend fun getMovieAnime(): Result<List<Anime>, NetworkError>
    suspend fun getSpecialAnime(): Result<List<Anime>, NetworkError>

}