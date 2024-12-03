package com.jesil.animequest.di

import com.jesil.animequest.anime.data.networking.RemoteAnimeDataSource
import com.jesil.animequest.anime.data.networking.RemoteTopAiringDataSource
import com.jesil.animequest.anime.data.networking.RemoteUpcomingDataSource
import com.jesil.animequest.anime.domain.AnimeDataSource
import com.jesil.animequest.anime.domain.TopAiringDataSource
import com.jesil.animequest.anime.domain.UpcomingDataSource
import com.jesil.animequest.anime.presentation.AnimeListViewModel
import com.jesil.animequest.anime.presentation.top_airing.TopAiringViewModel
import com.jesil.animequest.anime.presentation.upcoming.UpcomingListViewModel
import com.jesil.animequest.core.data.networking.HttpClientFactory
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single {HttpClientFactory.create(CIO.create())}

    singleOf(::RemoteAnimeDataSource) bind AnimeDataSource::class

    viewModelOf(::AnimeListViewModel) bind AnimeListViewModel::class

    singleOf(::RemoteUpcomingDataSource) bind UpcomingDataSource::class

    singleOf(::UpcomingListViewModel) bind UpcomingListViewModel::class

    singleOf(::RemoteTopAiringDataSource) bind TopAiringDataSource::class

    singleOf(::TopAiringViewModel) bind TopAiringViewModel::class
}