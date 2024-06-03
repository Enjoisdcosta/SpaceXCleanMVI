package com.example.data.remote.di

import com.example.data.remote.repository.RemoteCapsuleDataSource
import com.example.data.source.RemoteCapsuleDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindCapsuleInfoDataSource(dataSource: RemoteCapsuleDataSourceImpl): RemoteCapsuleDataSource
}