package com.example.data.remote.repository.history

import com.example.domain.entity.history.History
import kotlinx.coroutines.flow.Flow

interface RemoteHistoryDataSource {

    fun getHistory(): Flow<List<History?>?>

    fun getHistoryItem(id: Int?): Flow<History>
}