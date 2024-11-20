package com.jesil.animequest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jesil.animequest.anime.presentation.AnimeListScreen
import com.jesil.animequest.anime.presentation.AnimeListViewModel
import com.jesil.animequest.anime.presentation.component.AnimeTopAppBar
import com.jesil.animequest.anime.presentation.component.ChipGroup
import com.jesil.animequest.anime.presentation.model.AnimeSort
import com.jesil.animequest.anime.presentation.model.getAllAnimeSort
import com.jesil.animequest.anime.presentation.model.getValue
import com.jesil.animequest.ui.theme.AnimeQuestTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val selectedOption: MutableState<AnimeSort?> = mutableStateOf(null)

        setContent {
            AnimeQuestTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                    topBar = {
                        AnimeTopAppBar(
                            navigationIconAction = {},
                            actionIconAction = {}
                        )
                    }
                ) { innerPadding ->
                    val viewModel = koinViewModel<AnimeListViewModel>()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    Column(
                       modifier = Modifier.padding(innerPadding),
                       content = {
                           ChipGroup(
                               options = getAllAnimeSort(),
                               selectedOption = selectedOption.value,
                               onOptionSelected = {
                                   selectedOption.value = getValue(it)
                               }
                           )
                           Spacer(modifier = Modifier.padding(4.dp))
                           AnimeListScreen(
                               state = state
                           )
                       }
                   )
                }
            }
        }
    }
}