package com.example.data.remote.di

import com.example.data.remote.repository.capsule.RemoteCapsuleDataSource
import com.example.data.source.capsule.RemoteCapsuleDataSourceImpl
import com.example.data.source.history.RemoteHistoryDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteDataSourceModule {

    @Binds
    abstract fun bindCapsuleInfoDataSource(dataSource: RemoteCapsuleDataSourceImpl): RemoteCapsuleDataSource

    @Binds
    abstract fun bindHistoryInfoDataSource(dataSource: RemoteHistoryDataSourceImpl): RemoteHistoryDataSourceImpl
}