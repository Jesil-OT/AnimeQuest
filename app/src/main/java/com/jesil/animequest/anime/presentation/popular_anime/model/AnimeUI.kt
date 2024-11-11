package com.jesil.animequest.anime.presentation.popular_anime.model

import com.jesil.animequest.anime.domain.Anime

data class AnimeUI(
    val id: Int,
    val mainPicture: String,
    val title: String
)

fun Anime.toAnimeUI() = AnimeUI(
    id = node.id,
    mainPicture = node.mainPicture.medium,
    title = node.title
)
