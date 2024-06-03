package com.example.data.remote.repository

import com.example.data.remote.network.capsules.CapsulesItemModel
import kotlinx.coroutines.flow.Flow

interface CapsuleRepository {

    suspend fun getCapsules(): Flow<List<CapsulesItemModel?>?>
}