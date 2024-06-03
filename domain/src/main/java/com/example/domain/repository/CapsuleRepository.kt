package com.example.domain.repository

import com.example.domain.entity.Capsule
import kotlinx.coroutines.flow.Flow

interface CapsuleRepository {

    fun getCapsules(): Flow<List<Capsule?>?>

    fun getCapsule(capsuleId: String?): Flow<Capsule>
}