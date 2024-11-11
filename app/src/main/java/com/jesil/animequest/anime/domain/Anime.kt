package com.jesil.animequest.anime.domain

import kotlinx.serialization.SerialName

data class Anime(
    val node : AnimeNode,
    val ranking: AnimeRanking
)

data class AnimeNode(
    val id: Int,
    val title: String,
    val mainPicture: AnimeMainPicture,
)

data class AnimeMainPicture(
    val medium: String,
    val large: String
)

data class AnimeRanking(
    val rank: Int,
)