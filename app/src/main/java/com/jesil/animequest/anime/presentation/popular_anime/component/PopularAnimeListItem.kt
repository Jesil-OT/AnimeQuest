package com.jesil.animequest.anime.presentation.popular_anime.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.animequest.R
import com.jesil.animequest.anime.presentation.model.AnimeUI
import com.jesil.animequest.anime.presentation.model.toAnimeUI
import com.jesil.animequest.ui.theme.AnimeQuestTheme

@Composable
fun PopularAnimeListItem(
    modifier: Modifier = Modifier,
    popularAnime: List<AnimeUI> = emptyList(),
) {

    // to check if the system is in dark mode, then apply the correct color
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    val state = rememberLazyListState()
    val snapFlingBehavior = rememberSnapFlingBehavior(lazyListState = state)
    if (popularAnime.isEmpty()) return else {
        Column(
            modifier = modifier.padding(
                vertical = 10.dp
            ),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center,
            content = {
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.popular_anime),
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = contentColor
                    )
                    Surface(
                        modifier = Modifier.clickable { },
                        color = MaterialTheme.colorScheme.primary,
                        shape = RoundedCornerShape(30.dp),
                        content = {
                            Text(
                                modifier = Modifier.padding(horizontal = 5.dp,),
                                text = stringResource(R.string.see_all),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Normal,
                            )
                        }
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    contentPadding = PaddingValues(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    state = state,
                    flingBehavior = snapFlingBehavior,
                    content = {
                        items(popularAnime) {
                            PopularAnimeItem(
                                uiState = it,
                                state = state,
                                index = popularAnime.indexOf(it),
                                onClick = {}
                            )
                        }
                    }
                )
            }
        )
    }
}

@PreviewLightDark
@Composable
private fun PopularAnimeListItemPreview() {
    AnimeQuestTheme {
        PopularAnimeListItem(
            popularAnime = PopularAnimePreview,
            modifier = Modifier.background(MaterialTheme.colorScheme.background)
        )
    }
}

private val PopularAnimePreview = (1..10).map {
    AnimePreview.toAnimeUI()
}