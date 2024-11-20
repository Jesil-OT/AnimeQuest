package com.jesil.animequest.anime.data.networking.dto

import kotlinx.serialization.Serializable


@Serializable
data class AnimeResponseDto(
    val data: List<AnimeDto>,
    val paging : PagingDto
)

@Serializable
class PagingDto (
    val next: String
)

