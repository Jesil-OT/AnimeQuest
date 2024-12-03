package com.jesil.animequest.anime.presentation.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.animequest.ui.theme.AnimeQuestTheme

@Composable
fun AnimeSelector(
    modifier: Modifier = Modifier,
    text: String,
    selected: Boolean = false,
    onSelected: () -> Unit = {}
) {
    // to check if the system is in dark mode, then apply the correct color
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val backgroundColor by animateColorAsState(
        targetValue = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.background
    )
    val selectedColor by animateColorAsState(
        targetValue = if (selected) MaterialTheme.colorScheme.onPrimary else contentColor
    )

    val interactionSource = remember { MutableInteractionSource() }

    Surface(
        modifier = modifier.padding(6.dp),
        shape = RoundedCornerShape(20.dp),
        color = backgroundColor,
        content = {
            Row(
                modifier = Modifier.clickable(
                    interactionSource = interactionSource,
                    indication = null,
                    onClick = onSelected
                )
                .padding(horizontal = 5.dp),
                horizontalArrangement = Arrangement.Center,
                content = {
                    Text(
                        text = text,
                        fontWeight = FontWeight.Bold,
                        fontSize = 13.sp,
                        color = if (selected) Color.White else contentColor,
                        modifier = Modifier.padding(8.dp)
                    )
                }
            )

        }
    )

}

@PreviewLightDark
@Composable
private fun AnimeSelectorPreview() {
    AnimeQuestTheme {
        AnimeSelector(
            text = "Anime",
            selected = false,
            onSelected = {}
        )
    }
}