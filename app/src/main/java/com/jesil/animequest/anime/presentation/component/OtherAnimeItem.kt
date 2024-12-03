package com.jesil.animequest.anime.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.jesil.animequest.anime.presentation.model.AnimeUI
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.anime.presentation.popular_anime.component.AnimePreview
import com.jesil.animequest.ui.theme.AnimeQuestTheme

@Composable
fun OtherAnimeItem(
    modifier: Modifier = Modifier,
    width : Dp = 100.dp,
    height: Dp = 150.dp,
    uiState: AnimeUI,
    onClick: () -> Unit
) {
    // to check if the system is in dark mode, then apply the correct color
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.width(width),
        content = {
            AsyncImage(
                modifier = Modifier
                    .shadow(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .wrapContentWidth()
                    .height(height)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { onClick() },
                model = uiState.mainPicture,
                contentDescription = uiState.title,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = uiState.title,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = contentColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    )

}

@PreviewLightDark
@Composable
private fun OtherAnimeItemPreview() {
    AnimeQuestTheme {
        OtherAnimeItem(
            uiState = AnimePreview.toAnimeUI(),
            onClick = {}
        )
    }
}