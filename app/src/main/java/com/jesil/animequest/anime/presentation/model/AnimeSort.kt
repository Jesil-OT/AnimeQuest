package com.jesil.animequest.anime.presentation.model

enum class AnimeSort(var value: String) {
    ANIME("Anime"),
    UPCOMING("Upcoming"),
    AIRING("Top Airing"),
    TV_SPECIALS("TV Specials"),
    OVA_SERIES("OVA Series"),
    FAVORITES("Favorites")
}

fun getValue(value: String): AnimeSort?{
    val map = AnimeSort.entries.associateBy(AnimeSort::value)
    return map[value]
}

fun getSelectedOptionOptions(): List<AnimeSort> = AnimeSort.entries.toList()


