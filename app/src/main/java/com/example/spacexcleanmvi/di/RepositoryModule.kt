package com.example.spacexcleanmvi.di

import com.example.data.remote.repository.capsule.CapsuleRepositoryImpl
import com.example.data.remote.repository.capsule.RemoteCapsuleDataSource
import com.example.data.remote.repository.history.HistoryRepositoryImpl
import com.example.data.remote.repository.history.RemoteHistoryDataSource
import com.example.domain.repository.CapsuleRepository
import com.example.domain.repository.HistoryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    
    @Provides
    fun provideCapsuleRepository(
        remoteSource: RemoteCapsuleDataSource
    ) : CapsuleRepository = CapsuleRepositoryImpl(
        remoteSource
    )

    @Provides
    fun provideHistoryRepository(
        remoteSource: RemoteHistoryDataSource
    ): HistoryRepository = HistoryRepositoryImpl(
        remoteSource
    )
}