package com.jesil.animequest.anime.presentation.ova_series

import com.jesil.animequest.anime.presentation.model.AnimeUI

data class OvaSeriesState(
    val ovaSeries: List<AnimeUI> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
