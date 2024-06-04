package com.example.data.remote.repository.capsule

import com.example.domain.entity.capsule.Capsule
import com.example.domain.repository.CapsuleRepository
import kotlinx.coroutines.flow.Flow

class CapsuleRepositoryImpl(
    private val remoteSource: RemoteCapsuleDataSource
) : CapsuleRepository {
    override  fun getCapsules(): Flow<List<Capsule?>?> {
        return remoteSource.getCapsules()
    }

    override fun getCapsuleById(capsuleId: String?): Flow<Capsule> {
        return remoteSource.getCapsule(capsuleId)
    }


}