package com.jesil.animequest.anime.presentation.top_anime.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.jesil.animequest.R
import com.jesil.animequest.ui.theme.AnimeQuestTheme

@Composable
fun HotAnimeItem(
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.error,
        shape = RoundedCornerShape(30.dp),
        content = {
            Row(
                modifier = Modifier.padding(horizontal = 10.dp, vertical = 3.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                content = {
                    Icon(
                        modifier = Modifier.size(20.dp).padding(end = 5.dp),
                        imageVector = ImageVector.vectorResource(
                            id = R.drawable.hot_icon
                        ),
                        tint =  MaterialTheme.colorScheme.errorContainer,
                        contentDescription = stringResource(R.string.hot_steak)
                    )

                    Text(
                        text = stringResource(R.string.hot_steak),
                        fontSize = 12.sp,
                        color = MaterialTheme.colorScheme.errorContainer

                    )
                }
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun HotAnimeItemPreview() {
    AnimeQuestTheme {
        HotAnimeItem()
    }
}