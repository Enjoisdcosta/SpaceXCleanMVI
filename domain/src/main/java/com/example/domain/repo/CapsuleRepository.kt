package com.example.domain.repo

import com.example.domain.entity.Capsules
import kotlinx.coroutines.flow.Flow

interface CapsuleRepository {

    fun getCapsules(): Flow<List<Capsules?>?>

    fun getCapsule(movieId: Int?): Flow<Capsules>
}