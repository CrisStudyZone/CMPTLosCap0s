package org.example.project.di

import org.koin.compose.viewmodel.dsl.viewModel
import org.example.project.data.repository.MovieRepositoryImpl
import org.example.project.data.source.remote.ApiService
import org.example.project.data.source.remote.KtorClient
import org.example.project.domain.repository.MovieRepository
import org.example.project.ui.screen.login.home.HomeViewModel
import org.koin.dsl.module

val sharedModule = module {
    single { KtorClient.client }
    single { ApiService(get()) }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    viewModel {HomeViewModel(get()) }

}