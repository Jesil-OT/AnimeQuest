package com.jesil.animequest.anime.data.mapper

import com.jesil.animequest.anime.data.networking.dto.AnimeDto
import com.jesil.animequest.anime.data.networking.dto.AnimeMainPictureDto
import com.jesil.animequest.anime.data.networking.dto.AnimeNodeDto
import com.jesil.animequest.anime.data.networking.dto.AnimeRankingDto
import com.jesil.animequest.anime.domain.Anime
import com.jesil.animequest.anime.domain.AnimeMainPicture
import com.jesil.animequest.anime.domain.AnimeNode
import com.jesil.animequest.anime.domain.AnimeRanking

fun AnimeDto.toAnime(): Anime {
    return Anime(
        node = node.toAnimeNode(),
        ranking = ranking.toAnimeRanking()
    )
}

fun AnimeNodeDto.toAnimeNode(): AnimeNode {
    return AnimeNode(
        id = id,
        title = title,
        mainPicture = mainPicture.toAnimeMainPicture()
    )
}

fun AnimeMainPictureDto.toAnimeMainPicture(): AnimeMainPicture {
    return AnimeMainPicture(
        medium = medium,
        large = large
    )
}

fun AnimeRankingDto.toAnimeRanking(): AnimeRanking {
    return AnimeRanking(
        rank = rank
    )
}