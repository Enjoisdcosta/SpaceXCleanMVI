package com.example.data.remote.repository

import com.example.data.remote.api.APIEndpoints
import com.example.data.remote.network.capsules.CapsulesItemModel
import kotlinx.coroutines.flow.Flow

class CapsuleRepositoryImplementaion(  private val apiService: APIEndpoints
): CapsuleRepository {
    override suspend fun getCapsules(): Flow<List<CapsulesItemModel?>?> {
        return apiService.getCapsules()
    }
}