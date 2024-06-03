package com.example.data.remote.repository

import com.example.domain.entity.Capsule
import kotlinx.coroutines.flow.Flow

interface RemoteCapsuleDataSource {

    fun getCapsules(): Flow<List<Capsule?>?>

    fun getCapsule(id: String?): Flow<Capsule>
}