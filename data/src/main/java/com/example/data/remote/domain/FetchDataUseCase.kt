package com.example.data.remote.domain

import com.example.data.remote.network.capsules.CapsulesItemModel
import com.example.data.remote.repository.CapsuleRepository
import kotlinx.coroutines.flow.Flow

class FetchDataUseCase(private val repository: CapsuleRepository) {
    suspend operator fun invoke(): Flow<List<CapsulesItemModel?>?> {
        return repository.getCapsules()
    }
}