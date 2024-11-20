package com.jesil.animequest.anime.presentation

import androidx.compose.runtime.Immutable
import com.jesil.animequest.anime.presentation.model.AnimeUI

@Immutable
data class AnimeListState(
    val popularAnime: List<AnimeUI> = emptyList(),
    val topAnime: List<AnimeUI> = emptyList(),
    val movieAnime: List<AnimeUI> = emptyList(),
    val specialAnime: List<AnimeUI> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)