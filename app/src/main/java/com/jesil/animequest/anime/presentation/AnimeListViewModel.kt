package com.jesil.animequest.anime.presentation

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesil.animequest.anime.domain.AnimeDataSource
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.core.domain.utils.onError
import com.jesil.animequest.core.domain.utils.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class AnimeListViewModel(
    private val getAnimeDataSource: AnimeDataSource,
) : ViewModel() {

    private val _state = MutableStateFlow(AnimeListState())
    val state = _state
        .onStart { getAnime() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = AnimeListState()
        )


    private fun getAnime() {
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            getAnimeDataSource.apply {
                getPopularAnime()
                    .onSuccess { popularAnime ->
                        _state.update {
                            it.copy(
                                popularAnime = popularAnime.map { popularAnime -> popularAnime.toAnimeUI() },
                                isLoading = false
                            )
                        }
                    }
                    .onError {
                        _state.update {
                            it.copy(
                                error = it.error,
                                isLoading = false
                            )
                        }
                    }

                getTopAnime()
                    .onSuccess { topAnime ->
                        _state.update {
                            it.copy(
                                topAnime = topAnime.map { topAnime -> topAnime.toAnimeUI() },
                                isLoading = false
                            )
                        }
                    }.onError {
                        _state.update {
                            it.copy(
                                error = it.error,
                                isLoading = false
                            )
                        }
                    }

                getMovieAnime()
                    .onSuccess { movieAnime ->
                        _state.update {
                            it.copy(
                                movieAnime = movieAnime.map { movieAnime -> movieAnime.toAnimeUI() },
                                isLoading = false
                            )
                        }
                    }.onError {
                        _state.update {
                            it.copy(
                                error = it.error,
                                isLoading = false
                            )
                        }
                    }

                getSpecialAnime()
                    .onSuccess { specialAnime ->
                        _state.update {
                            it.copy(
                                specialAnime = specialAnime.map { specialAnime -> specialAnime.toAnimeUI() },
                                isLoading = false
                            )
                        }
                    }.onError {
                        _state.update {
                            it.copy(
                                error = it.error,
                                isLoading = false
                            )
                        }
                    }

            }
        }
    }

}