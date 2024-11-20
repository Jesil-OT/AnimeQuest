package com.jesil.animequest.anime.presentation.popular_anime.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.jesil.animequest.anime.domain.Anime
import com.jesil.animequest.anime.domain.AnimeMainPicture
import com.jesil.animequest.anime.domain.AnimeNode
import com.jesil.animequest.anime.domain.AnimeRanking
import com.jesil.animequest.anime.presentation.model.AnimeUI
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.ui.theme.AnimeQuestTheme

@Composable
fun PopularAnimeItem(
    modifier: Modifier = Modifier,
    uiState: AnimeUI,
    onClick: () -> Unit
) {

    // to check if the system is in dark mode, then apply the correct color
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.width(120.dp),
        content = {
            AsyncImage(
                modifier = Modifier
                    .shadow(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .wrapContentWidth()
                    .height(190.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { onClick() }
                ,
                model = uiState.mainPicture,
                contentDescription = uiState.title,
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = uiState.title,
                fontSize = 13.sp,
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
fun PopularAnimeItemPreview() {
    AnimeQuestTheme {
        PopularAnimeItem(
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