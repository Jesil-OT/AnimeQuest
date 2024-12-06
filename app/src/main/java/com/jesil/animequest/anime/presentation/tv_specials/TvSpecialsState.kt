package com.jesil.animequest.anime.presentation.tv_specials

import com.jesil.animequest.anime.presentation.model.AnimeUI

data class TvSpecialsState(
    val tvSpecials: List<AnimeUI> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
