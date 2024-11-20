package com.jesil.animequest.anime.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.jesil.animequest.R
import com.jesil.animequest.anime.presentation.component.OtherAnimeListItem
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.anime.presentation.popular_anime.component.AnimePreview
import com.jesil.animequest.anime.presentation.popular_anime.component.PopularAnimeListItem
import com.jesil.animequest.anime.presentation.top_anime.component.TopAnimeListItem
import com.jesil.animequest.ui.theme.AnimeQuestTheme

@Composable
fun AnimeListScreen(
    state: AnimeListState,
    modifier: Modifier = Modifier
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
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            TopAnimeListItem(
                topAnime = state.topAnime
            )
            PopularAnimeListItem(
                popularAnime = state.popularAnime
            )
            OtherAnimeListItem(
                otherAnime = state.movieAnime,
                headerText = stringResource(R.string.movie_anime)
            )
            OtherAnimeListItem(
                otherAnime = state.specialAnime,
                headerText = stringResource(R.string.special_anime)
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun AnimeListScreenPreview() {
    AnimeQuestTheme {
        AnimeListScreen(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
            state = AnimeListStateUI
        )
    }
}

private val AnimeListStateUI = AnimeListState(
    topAnime = (1..10).map { AnimePreview.toAnimeUI() },
    popularAnime = (1..10).map { AnimePreview.toAnimeUI() },
    isLoading = false,
    error = ""
)