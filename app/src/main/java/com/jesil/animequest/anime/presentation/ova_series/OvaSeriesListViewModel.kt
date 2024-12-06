package com.jesil.animequest.anime.presentation.ova_series

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesil.animequest.anime.domain.OvaSeriesDataSource
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.core.domain.utils.onError
import com.jesil.animequest.core.domain.utils.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class OvaSeriesListViewModel(
    private val ovaSeriesDataSource: OvaSeriesDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(OvaSeriesState())
    val state = _state
        .onStart { getOvaSeries() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = OvaSeriesState()
        )

    private fun getOvaSeries() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            ovaSeriesDataSource.getOvaSeries()
                .onSuccess { ovaSeries ->
                    _state.update {
                        it.copy(
                            ovaSeries = ovaSeries.map { ovaSeries -> ovaSeries.toAnimeUI() },
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
        }

    }
}