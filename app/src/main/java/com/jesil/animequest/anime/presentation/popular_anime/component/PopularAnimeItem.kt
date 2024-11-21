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
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import com.jesil.animequest.anime.domain.Anime
import com.jesil.animequest.anime.domain.AnimeMainPicture
import com.jesil.animequest.anime.domain.AnimeNode
import com.jesil.animequest.anime.domain.AnimeRanking
import com.jesil.animequest.anime.presentation.model.AnimeUI
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.ui.theme.AnimeQuestTheme
import kotlin.math.abs

@Composable
fun PopularAnimeItem(
    modifier: Modifier = Modifier,
    uiState: AnimeUI,
    state: LazyListState,
    index: Int,
    onClick: () -> Unit
) {

    // to check if the system is in dark mode, then apply the correct color
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    val scale by remember {
        derivedStateOf {
            val currentItem = state.layoutInfo.visibleItemsInfo.firstOrNull { it.index == index }
                ?: return@derivedStateOf 1.0f
            val halfRowWidth = state.layoutInfo.viewportSize.width / 2
            (1f - minOf(
                1f,
                abs(currentItem.offset + (currentItem.size / 2) - halfRowWidth).toFloat() / halfRowWidth
            ) * 0.10f)
        }
    }

    Column(
        verticalArrangement = Arrangement.Center,
        modifier = modifier.width(120.dp),
        content = {
            AsyncImage(
                modifier = Modifier
                    .height(190.dp)
                    .wrapContentWidth()
                    .scale(scale)
                    .zIndex(scale * 10)
                    .clip(RoundedCornerShape(10.dp))
                    .shadow(
                        elevation = 1.dp,
                        shape = RoundedCornerShape(20.dp)
                    )
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
            state = rememberLazyListState(),
            index = 0,
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