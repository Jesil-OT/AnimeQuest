package com.jesil.animequest.anime.presentation.top_anime.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import coil3.compose.AsyncImage
import com.jesil.animequest.anime.presentation.model.AnimeUI
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.anime.presentation.popular_anime.component.AnimePreview
import com.jesil.animequest.ui.theme.AnimeQuestTheme
import kotlin.math.abs

@Composable
fun TopAnimeItem(
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
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.width(180.dp),
        content = {
            Box(
                modifier = Modifier.wrapContentSize().clickable { onClick() },
                content = {
                    AsyncImage(
                        modifier = modifier
                            .height(280.dp)
                            .scale(scale)
                            .zIndex(scale * 10)
                            .clip(RoundedCornerShape(20.dp))
                            .shadow(
                                elevation = 1.dp,
                                shape = RoundedCornerShape(20.dp)
                            )
                            .clickable { onClick() },
                        model = uiState.mainPicture,
                        contentDescription = uiState.title,
                        contentScale = ContentScale.Crop
                    )

                    Box(
                        modifier = Modifier.fillMaxSize()
                            .scale(scale)
                            .zIndex(scale * 10),
                        content = {
                            HotAnimeItem(
                                modifier = Modifier.align(Alignment.TopEnd)
                            )
                        }
                    )
                }
            )

            Text(
                text = uiState.title,
                fontSize = 10.sp,
                fontWeight = FontWeight.Bold,
                color = contentColor,
                textAlign = TextAlign.Center
            )
        }
    )
}


@PreviewLightDark
@Composable
private fun TopAnimeItemPreview() {
    AnimeQuestTheme {
        TopAnimeItem(
            uiState = AnimePreview.toAnimeUI(),
            state = rememberLazyListState(),
            index = 0,
            onClick = {}
        )
    }
}