package com.jesil.animequest.anime.presentation.ova_series

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.jesil.animequest.anime.presentation.component.OtherAnimeItem
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.anime.presentation.popular_anime.component.AnimePreview
import com.jesil.animequest.anime.presentation.tv_specials.TvSpecialsState

@Composable
fun OvaSeriesListScreen(
    modifier: Modifier = Modifier,
    state: OvaSeriesState
) = if (state.isLoading) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center,
        content = {
            CircularProgressIndicator()
        }
    )
} else {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(
                horizontal = 20.dp,
                vertical = 10.dp
            ),
        horizontalAlignment = Alignment.Start,
        content = {
            LazyVerticalGrid(
                state = rememberLazyGridState(),
                columns = GridCells.Fixed(count = 2),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                content = {
                    items(state.ovaSeries) {
                        OtherAnimeItem(
                            height = 250.dp,
                            uiState = it,
                            onClick = {}
                        )
                    }
                },
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun OvaSeriesListScreenPreview() {
    OvaSeriesListScreen(
        state = OvaSeriesStateUI
    )
}

private val OvaSeriesStateUI = OvaSeriesState(
    ovaSeries = (1..10).map { AnimePreview.toAnimeUI() },
    error = "",
    isLoading = false
)