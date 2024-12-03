package com.jesil.animequest.anime.presentation.upcoming

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesil.animequest.anime.domain.UpcomingDataSource
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.core.domain.utils.onError
import com.jesil.animequest.core.domain.utils.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class UpcomingListViewModel(
    private val getUpcomingDataSource: UpcomingDataSource
): ViewModel() {
    private val _state = MutableStateFlow(UpcomingListState())
    val state = _state
        .onStart { getUpcoming() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = UpcomingListState()
        )

    private fun getUpcoming(){
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            getUpcomingDataSource.getUpComingAnime()
                .onSuccess { upcomingAnime ->
                    _state.update {
                        it.copy(
                            upcomingAnime = upcomingAnime.map { upcomingAnime -> upcomingAnime.toAnimeUI() },
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