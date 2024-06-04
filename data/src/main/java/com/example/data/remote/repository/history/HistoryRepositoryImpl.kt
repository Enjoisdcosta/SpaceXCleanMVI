package com.example.data.remote.repository.history

import com.example.domain.entity.capsule.Capsule
import com.example.domain.entity.history.History
import com.example.domain.repository.CapsuleRepository
import com.example.domain.repository.HistoryRepository
import kotlinx.coroutines.flow.Flow

class HistoryRepositoryImpl(
    private val remoteSource: RemoteHistoryDataSource
) : HistoryRepository {
    override  fun getHistory(): Flow<List<History?>?> {
        return remoteSource.getHistory()
    }
    override fun getHistoryItem(id: Int?): Flow<History> {
        return remoteSource.getHistoryItem(id)
    }
}