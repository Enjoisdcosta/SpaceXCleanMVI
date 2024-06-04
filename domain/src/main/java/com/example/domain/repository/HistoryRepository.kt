package com.example.domain.repository

import com.example.domain.entity.history.History
import kotlinx.coroutines.flow.Flow

interface HistoryRepository {


    fun getHistory(): Flow<List<History?>?>
    fun getHistoryItem(id: Int?): Flow<History>
}