package com.jesil.animequest.anime.presentation.top_airing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesil.animequest.anime.domain.TopAiringDataSource
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.core.domain.utils.onError
import com.jesil.animequest.core.domain.utils.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TopAiringViewModel(
    private val topAiringDataSource: TopAiringDataSource
): ViewModel() {
    private val _state = MutableStateFlow(TopAiringListState())
    val state = _state
        .onStart { getTopAiringAnime() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = TopAiringListState()
        )

    private fun getTopAiringAnime() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            topAiringDataSource.getTopAiringAnime()
                .onSuccess { topAiring ->
                    _state.update {
                        it.copy(
                            topAiringAnime = topAiring.map { data -> data.toAnimeUI() },
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