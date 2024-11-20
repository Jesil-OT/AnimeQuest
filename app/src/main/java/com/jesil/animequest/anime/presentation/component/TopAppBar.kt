package com.jesil.animequest.anime.presentation.component

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.sp
import com.jesil.animequest.R
import com.jesil.animequest.ui.theme.AnimeQuestTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnimeTopAppBar(
    navigationIconAction : () -> Unit,
    actionIconAction : () -> Unit
) {
    // to check if the system is in dark mode, then apply the correct color
    val contentColor = if (isSystemInDarkTheme()) Color.White else Color.Black

    CenterAlignedTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = contentColor
        ),
        title = {
            Text(
                buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            color = contentColor
                        )
                    ) {
                        append("Anime")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp,
                            color = MaterialTheme.colorScheme.primary
                        )
                    ) {
                        append("Quest")
                    }
                }
            )
        },
        navigationIcon = {
            IconButton(
                onClick = {navigationIconAction()},
                content = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = stringResource(R.string.menu),
                        tint = contentColor
                    )
                }
            )
        },
        actions = {
            IconButton(
                onClick = {actionIconAction()},
                content = {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        contentDescription = stringResource(R.string.action),
                        tint = contentColor
                    )
                }
            )
        }
    )
}

@PreviewLightDark
@Composable
private fun AnimeTopAppBarPreview() {
    AnimeQuestTheme {
        AnimeTopAppBar(
            navigationIconAction = {},
            actionIconAction = {}
        )
    }
}