package com.example.spacexcleanmvi.di

import com.example.data.remote.repository.CapsuleRepositoryImpl
import com.example.data.remote.repository.RemoteCapsuleDataSource
import com.example.domain.repository.CapsuleRepository
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
}