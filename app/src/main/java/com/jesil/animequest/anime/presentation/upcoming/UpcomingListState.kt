package com.jesil.animequest.anime.presentation.upcoming

import androidx.compose.runtime.Immutable
import com.jesil.animequest.anime.presentation.model.AnimeUI

@Immutable
data class UpcomingListState(
    val upcomingAnime: List<AnimeUI> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = ""
)
