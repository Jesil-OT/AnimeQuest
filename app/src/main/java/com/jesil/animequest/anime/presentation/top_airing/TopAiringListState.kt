package com.jesil.animequest.anime.presentation.top_airing

import androidx.compose.runtime.Immutable
import com.jesil.animequest.anime.presentation.model.AnimeUI

@Immutable
data class TopAiringListState(
    val topAiringAnime: List<AnimeUI> = emptyList(),
    val isLoading : Boolean = false,
    val error: String = "",
)