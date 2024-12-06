package com.jesil.animequest.di

import org.koin.dsl.module
import com.jesil.animequest.anime.data.networking.RemoteAnimeDataSource
import com.jesil.animequest.anime.data.networking.RemoteFavoriteDataSource
import com.jesil.animequest.anime.data.networking.RemoteOvaSeriesDataSource
import com.jesil.animequest.anime.data.networking.RemoteTopAiringDataSource
import com.jesil.animequest.anime.data.networking.RemoteTvSpecialsDataSource
import com.jesil.animequest.anime.data.networking.RemoteUpcomingDataSource
import com.jesil.animequest.anime.domain.AnimeDataSource
import com.jesil.animequest.anime.domain.FavoriteDataSource
import com.jesil.animequest.anime.domain.OvaSeriesDataSource
import com.jesil.animequest.anime.domain.TopAiringDataSource
import com.jesil.animequest.anime.domain.TvSpecialsDataSource
import com.jesil.animequest.anime.domain.UpcomingDataSource
import com.jesil.animequest.anime.presentation.AnimeListViewModel
import com.jesil.animequest.anime.presentation.favorites.FavoritesListViewModel
import com.jesil.animequest.anime.presentation.ova_series.OvaSeriesListViewModel
import com.jesil.animequest.anime.presentation.top_airing.TopAiringViewModel
import com.jesil.animequest.anime.presentation.tv_specials.TvSpecialsListViewModel
import com.jesil.animequest.anime.presentation.upcoming.UpcomingListViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind

val animeModule = module {
    singleOf(::RemoteAnimeDataSource) bind AnimeDataSource::class

    viewModelOf(::AnimeListViewModel) bind AnimeListViewModel::class

    singleOf(::RemoteUpcomingDataSource) bind UpcomingDataSource::class

    singleOf(::UpcomingListViewModel) bind UpcomingListViewModel::class

    singleOf(::RemoteTopAiringDataSource) bind TopAiringDataSource::class

    singleOf(::TopAiringViewModel) bind TopAiringViewModel::class

    singleOf(::RemoteTvSpecialsDataSource) bind TvSpecialsDataSource::class

    singleOf(::TvSpecialsListViewModel) bind TvSpecialsListViewModel::class

    singleOf(::RemoteOvaSeriesDataSource) bind OvaSeriesDataSource::class

    singleOf(::OvaSeriesListViewModel) bind OvaSeriesListViewModel::class

    singleOf(::RemoteFavoriteDataSource) bind FavoriteDataSource::class

    singleOf(::FavoritesListViewModel) bind FavoritesListViewModel::class
}