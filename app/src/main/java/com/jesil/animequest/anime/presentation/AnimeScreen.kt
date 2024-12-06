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
import com.jesil.animequest.anime.presentation.favorites.FavoritesListScreen
import com.jesil.animequest.anime.presentation.favorites.FavoritesListViewModel
import com.jesil.animequest.anime.presentation.model.AnimeSort
import com.jesil.animequest.anime.presentation.model.getSelectedOptionOptions
import com.jesil.animequest.anime.presentation.ova_series.OvaSeriesListScreen
import com.jesil.animequest.anime.presentation.ova_series.OvaSeriesListViewModel
import com.jesil.animequest.anime.presentation.top_airing.TopAiringListScreen
import com.jesil.animequest.anime.presentation.top_airing.TopAiringViewModel
import com.jesil.animequest.anime.presentation.tv_specials.TvSpecialsListScreen
import com.jesil.animequest.anime.presentation.tv_specials.TvSpecialsListViewModel
import com.jesil.animequest.anime.presentation.upcoming.UpcomingListScreen
import com.jesil.animequest.anime.presentation.upcoming.UpcomingListViewModel
import com.jesil.animequest.ui.theme.AnimeQuestTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun AnimeScreen(
    animeListViewModel: AnimeListViewModel = koinViewModel(),
    upcomingListViewModel: UpcomingListViewModel = koinViewModel(),
    topAiringViewModel: TopAiringViewModel = koinViewModel(),
    tvSpecialsListViewModel: TvSpecialsListViewModel = koinViewModel(),
    ovaSeriesListViewModel: OvaSeriesListViewModel = koinViewModel(),
    favoritesListViewModel: FavoritesListViewModel = koinViewModel(),
    modifier: Modifier = Modifier
) {
    val animeListState by animeListViewModel.state.collectAsStateWithLifecycle()
    var selectedLabel by rememberSaveable { mutableStateOf(getSelectedOptionOptions().first()) }

    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        content = {
            AnimeChipGroup(
                showChip = animeListState.topAnime.isNotEmpty(),
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
                    val upcomingListState by upcomingListViewModel.state.collectAsStateWithLifecycle()
                    UpcomingListScreen(
                        modifier = modifier,
                        state = upcomingListState
                    )
                }

                AnimeSort.AIRING -> {
                    val topAiringListState by topAiringViewModel.state.collectAsStateWithLifecycle()
                    TopAiringListScreen(
                        modifier = modifier,
                        state = topAiringListState
                    )
                }

                AnimeSort.TV_SPECIALS -> {
                    val tvSpecialsListState by tvSpecialsListViewModel.state.collectAsStateWithLifecycle()
                    TvSpecialsListScreen(
                        modifier = modifier,
                        state = tvSpecialsListState
                    )
                }

                AnimeSort.OVA_SERIES -> {
                    val ovaSeriesListState by ovaSeriesListViewModel.state.collectAsStateWithLifecycle()
                    OvaSeriesListScreen(
                        modifier = modifier,
                        state = ovaSeriesListState
                    )
                }

                AnimeSort.FAVORITES -> {
                    val favoritesListState by favoritesListViewModel.state.collectAsStateWithLifecycle()
                    FavoritesListScreen(
                        modifier = modifier,
                        state = favoritesListState
                    )
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


