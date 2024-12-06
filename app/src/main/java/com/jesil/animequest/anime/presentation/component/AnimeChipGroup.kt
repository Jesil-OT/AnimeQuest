package com.jesil.animequest.anime.presentation.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jesil.animequest.anime.presentation.model.AnimeSort
import com.jesil.animequest.anime.presentation.model.getSelectedOptionOptions

@Composable
fun AnimeChipGroup(
    showChip: Boolean,
    modifier: Modifier = Modifier,
    labelItems: List<AnimeSort> = listOf(),
    selectItems: AnimeSort? = null,
    onOptionSelected: (AnimeSort) -> Unit
) {
    if (!showChip) return else {
        LazyRow(
            modifier = modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 4.dp),
            content = {
                items(labelItems) { labelItem ->
                    AnimeSelector(
                        text = labelItem.value,
                        selected = labelItem.value == selectItems?.value,
                        onSelected = {
                            onOptionSelected(labelItem)
                        }
                    )
                }
            }
        )
    }
}