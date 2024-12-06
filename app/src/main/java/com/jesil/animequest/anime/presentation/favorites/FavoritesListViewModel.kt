package com.jesil.animequest.anime.presentation.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jesil.animequest.anime.domain.FavoriteDataSource
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.core.domain.utils.onError
import com.jesil.animequest.core.domain.utils.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FavoritesListViewModel(
    private val favoriteDataSource: FavoriteDataSource
): ViewModel() {
    private val _state = MutableStateFlow(FavoritesListState())
    val state = _state
        .onStart {
            getFavoriteAnime()
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = FavoritesListState()
        )


    private fun getFavoriteAnime(){
        viewModelScope.launch {
            _state.update {
                it.copy(isLoading = true)
            }

            favoriteDataSource.getFavoriteAnime()
                .onSuccess { favoriteAnime ->
                    _state.update {
                        it.copy(
                            favoriteAnime = favoriteAnime.map { favoriteAnime -> favoriteAnime.toAnimeUI() },
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