package com.jesil.animequest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.jesil.animequest.anime.presentation.AnimeListScreen
import com.jesil.animequest.anime.presentation.AnimeListViewModel
import com.jesil.animequest.anime.presentation.AnimeScreen
import com.jesil.animequest.anime.presentation.component.AnimeTopAppBar
import com.jesil.animequest.ui.theme.AnimeQuestTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AnimeQuestTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background),
                    topBar = {
                        AnimeTopAppBar(
                            navigationIconAction = {},
                            actionIconAction = {}
                        )
                    },
                ) { innerPadding ->
                    Column(
                       modifier = Modifier.padding(innerPadding),
                       content = {
                           AnimeScreen()
                       }
                   )
                }
            }
        }
    }
}