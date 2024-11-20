package com.jesil.animequest.anime.data.networking.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AnimeDto(
    val node: AnimeNodeDto,
    val ranking: AnimeRankingDto
)

@Serializable
data class AnimeNodeDto(
    val id: Int,
    val title: String,
    @SerialName("main_picture")
    val mainPicture: AnimeMainPictureDto
)

@Serializable
data class AnimeMainPictureDto(
    val medium: String,
    val large: String
)

@Serializable
data class AnimeRankingDto(
    val rank: Int,
)
