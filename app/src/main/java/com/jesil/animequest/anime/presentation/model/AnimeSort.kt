package com.jesil.animequest.anime.presentation.model

enum class AnimeSort(val value: String) {
    ANIME("Anime"),
    MANGA("Manga"),
    SUGGESTED("Suggested Anime"),
    UPCOMING("Upcoming Anime")
}

fun getAllAnimeSort() : List<AnimeSort> =
    listOf(AnimeSort.ANIME, AnimeSort.MANGA, AnimeSort.SUGGESTED, AnimeSort.UPCOMING)

fun getValue(value: String): AnimeSort?{
    val map = AnimeSort.entries.associateBy(AnimeSort::value)
    return map[value]
}