package com.jesil.animequest.anime.presentation.favorites

import com.jesil.animequest.anime.presentation.model.AnimeUI

data class FavoritesListState(
    val favoriteAnime: List<AnimeUI> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
