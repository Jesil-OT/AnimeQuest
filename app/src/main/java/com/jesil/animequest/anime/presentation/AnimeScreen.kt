package com.jesil.animequest.anime.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jesil.animequest.anime.presentation.component.AnimeChipGroup
import com.jesil.animequest.anime.presentation.model.AnimeSort
import com.jesil.animequest.anime.presentation.model.getSelectedOptionOptions
import com.jesil.animequest.anime.presentation.top_airing.TopAiringListScreen
import com.jesil.animequest.anime.presentation.top_airing.TopAiringViewModel
import com.jesil.animequest.anime.presentation.upcoming.UpcomingListScreen
import com.jesil.animequest.anime.presentation.upcoming.UpcomingListViewModel
import com.jesil.animequest.ui.theme.AnimeQuestTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun AnimeScreen(
    animeListViewModel: AnimeListViewModel = koinViewModel(),
    upcomingListViewModel: UpcomingListViewModel = koinViewModel(),
    topAiringViewModel: TopAiringViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    val animeListState by animeListViewModel.state.collectAsStateWithLifecycle()
    val upcomingListState by upcomingListViewModel.state.collectAsStateWithLifecycle()
    val topAiringListState by topAiringViewModel.state.collectAsStateWithLifecycle()
    var selectedLabel by rememberSaveable { mutableStateOf(getSelectedOptionOptions().first()) }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            AnimeChipGroup(
                showChip = animeListState.popularAnime.isNotEmpty(),
                labelItems = getSelectedOptionOptions(),
                selectItems = selectedLabel,
                onOptionSelected = {
                    selectedLabel = it
                }
            )
            Spacer(modifier = Modifier.padding(4.dp))
            when (selectedLabel) {
                AnimeSort.ANIME -> {
                    AnimeListScreen(
                        state = animeListState
                    )
                }
                AnimeSort.UPCOMING -> {
                    UpcomingListScreen(
                        modifier = modifier,
                        state = upcomingListState
                    )
                }
                AnimeSort.AIRING -> {
                    TopAiringListScreen(
                        modifier = modifier,
                        state = topAiringListState
                    )
                }
                AnimeSort.TV_SPECIALS -> {
                    Box(
                        modifier = modifier.fillMaxSize(),
                    ) {
                        Text(text = "TV Specials Anime")
                    }
                }

                AnimeSort.OVA_SERIES -> {
                    Box(
                        modifier = modifier.fillMaxSize(),
                    ) {
                        Text(text = AnimeSort.OVA_SERIES.value)
                    }
                }
                AnimeSort.FAVORITES -> {
                    Box(
                        modifier = modifier.fillMaxSize(),
                    ) {
                        Text(text = "Favorites Anime")
                    }
                }
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun AnimeListScreenPreview() {
    AnimeQuestTheme {
        AnimeScreen(
            modifier = Modifier.background(MaterialTheme.colorScheme.background),
        )
    }
}


