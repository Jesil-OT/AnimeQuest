package com.jesil.animequest.anime.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jesil.animequest.anime.presentation.model.AnimeSort

@Composable
fun ChipGroup(
    modifier: Modifier = Modifier,
    options: List<AnimeSort>,
    selectedOption: AnimeSort? = null,
    onOptionSelected: (String) -> Unit
) {
    LazyRow(
        modifier = modifier.fillMaxWidth(),
        contentPadding = PaddingValues(horizontal = 4.dp),
        content = {
            items(options){ option ->
                Chip(
                    name = option.value,
                    isSelected = selectedOption == option,
                    onSelectedChanged = {
                        onOptionSelected(it)
                    }
                )
            }
        }
    )
}