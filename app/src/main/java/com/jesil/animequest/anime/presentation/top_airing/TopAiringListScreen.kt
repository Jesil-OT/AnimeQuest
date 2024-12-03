package com.jesil.animequest.anime.presentation.top_airing

import androidx.compose.foundation.background
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.jesil.animequest.anime.presentation.component.OtherAnimeItem
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.anime.presentation.popular_anime.component.AnimePreview
import com.jesil.animequest.anime.presentation.upcoming.UpcomingListState
import com.jesil.animequest.ui.theme.AnimeQuestTheme

@Composable
fun TopAiringListScreen(
    modifier: Modifier = Modifier,
    state: TopAiringListState
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
                    items(state.topAiringAnime) {
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
private fun TopAiringListScreenPreview() {
    AnimeQuestTheme {
        TopAiringListScreen(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            state = TopAiringListStateUI
        )
    }
}

private val TopAiringListStateUI = TopAiringListState(
    topAiringAnime = (1..10).map { AnimePreview.toAnimeUI() },
    error = "",
    isLoading = false
)

