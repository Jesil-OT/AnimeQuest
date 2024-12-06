package com.jesil.animequest.anime.presentation.tv_specials

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesil.animequest.anime.domain.TvSpecialsDataSource
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.core.domain.utils.onError
import com.jesil.animequest.core.domain.utils.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TvSpecialsListViewModel(
    private val getTvSpecialsDataSource: TvSpecialsDataSource
) : ViewModel() {

    private val _state = MutableStateFlow(TvSpecialsState())
    val state = _state
        .onStart { getTvSpecials() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000L),
            initialValue = TvSpecialsState()
        )


    private fun getTvSpecials() {
        viewModelScope.launch {
            _state.update {
                it.copy(
                    isLoading = true
                )
            }

            getTvSpecialsDataSource.getTvSpecialAnime()
                .onSuccess { tvSpecials ->
                    _state.update {
                        it.copy(
                            tvSpecials = tvSpecials.map { tvSpecial -> tvSpecial.toAnimeUI() },
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