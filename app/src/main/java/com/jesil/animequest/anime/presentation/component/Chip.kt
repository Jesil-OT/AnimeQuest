package com.jesil.animequest.anime.presentation.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.animequest.anime.presentation.model.AnimeSort
import com.jesil.animequest.ui.theme.AnimeQuestTheme

@Composable
fun Chip(
    modifier: Modifier = Modifier,
    name: String,
    isSelected: Boolean = false,
    onSelectedChanged: (String) -> Unit = {}
) {
    // to check if the system is in dark mode, then apply the correct color
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Surface(
        modifier = modifier.padding(6.dp),
        shape = RoundedCornerShape(24.dp),
        color = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background,
        content = {
            Row(
                modifier = Modifier.toggleable(
                    value = isSelected,
                    onValueChange = {
                        onSelectedChanged(name)
                    }
                ).padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.Center,
                content = {
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        fontSize = 15.sp,
                        color = if (isSelected) Color.White else contentColor,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            )
        }
    )
}


@PreviewLightDark
@Composable
private fun ChipPreview() {
    AnimeQuestTheme {
        Chip(
            name = AnimeSort.ANIME.value,
            isSelected = true,
            onSelectedChanged = {}
        )
    }
}