package com.example.domain.repository

import com.example.domain.entity.Capsules
import kotlinx.coroutines.flow.Flow

interface CapsuleRepository {

    fun getCapsules(): Flow<List<Capsules?>?>

    fun getCapsule(capsuleId: Int?): Flow<Capsules>
}