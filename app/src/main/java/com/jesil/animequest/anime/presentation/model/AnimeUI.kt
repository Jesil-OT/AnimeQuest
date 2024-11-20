package com.jesil.animequest.anime.presentation.model

import com.jesil.animequest.anime.domain.Anime

data class AnimeUI(
    val id: Int,
    val mainPicture: String,
    val title: String
)

fun Anime.toAnimeUI() = AnimeUI(
    id = node.id,
    mainPicture = node.mainPicture.large,
    title = node.title
)
