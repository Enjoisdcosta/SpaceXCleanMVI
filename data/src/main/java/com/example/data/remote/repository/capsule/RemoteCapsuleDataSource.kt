package com.example.data.remote.repository.capsule

import com.example.domain.entity.capsule.Capsule
import kotlinx.coroutines.flow.Flow

interface RemoteCapsuleDataSource {

    fun getCapsules(): Flow<List<Capsule?>?>

    fun getCapsule(id: String?): Flow<Capsule>
}