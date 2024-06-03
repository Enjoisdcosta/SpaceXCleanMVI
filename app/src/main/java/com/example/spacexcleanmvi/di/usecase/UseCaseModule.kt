package com.example.spacexcleanmvi.di.usecase

import com.example.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideUseConfiguration(): UseCase.Configuration = UseCase.Configuration(Dispatchers.IO)
}