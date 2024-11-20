package com.jesil.animequest.di

import com.jesil.animequest.anime.data.networking.RemoteAnimeDataSource
import com.jesil.animequest.anime.domain.AnimeDataSource
import com.jesil.animequest.anime.presentation.AnimeListViewModel
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
}