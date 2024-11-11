package com.jesil.animequest.anime.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.jesil.animequest.anime.domain.Anime
import com.jesil.animequest.anime.domain.AnimeMainPicture
import com.jesil.animequest.anime.domain.AnimeNode
import com.jesil.animequest.anime.domain.AnimeRanking
import com.jesil.animequest.anime.presentation.popular_anime.model.AnimeUI
import com.jesil.animequest.anime.presentation.popular_anime.model.toAnimeUI
import com.jesil.animequest.ui.theme.AnimeQuestTheme

@Composable
fun AnimeItem(
    modifier: Modifier = Modifier,
    uiState: AnimeUI,
    onClick: () -> Unit
) {

    // to check if the system is in dark mode, then apply the correct color
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Column(
        modifier = modifier
            .clickable { onClick() },
        content = {
            AsyncImage(
                modifier = Modifier
                    .size(width = 150.dp, height = 200.dp)
                    .clip(RoundedCornerShape(10.dp)),
                model = uiState.mainPicture,
                contentDescription = uiState.title
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = uiState.title,
                fontSize = 13.sp,
                fontWeight = FontWeight.Normal,
                color = contentColor
            )
        }
    )
}

@PreviewLightDark
@Composable
fun AnimeItemPreview() {
    AnimeQuestTheme {
        AnimeItem(
            uiState = AnimePreview.toAnimeUI(),
            onClick = {}
        )
    }
}

internal val AnimePreview = Anime(
    node = AnimeNode(
        id = 1,
        title = "One Piece fan letter",
        mainPicture = AnimeMainPicture(
            medium = "https://cdn.myanimelist.net/images/anime/1455/146229.jpg",
            large = "https://cdn.myanimelist.net/images/anime/1455/146229.jpg"
        )
    ),
    ranking = AnimeRanking(
        rank = 1
    )
)