package com.example.domain.repository

import com.example.domain.entity.Capsule
import com.example.domain.entity.History
import kotlinx.coroutines.flow.Flow

interface CapsuleRepository {

    fun getCapsules(): Flow<List<Capsule?>?>

    fun getCapsuleById(capsuleId: String?): Flow<Capsule>


}
