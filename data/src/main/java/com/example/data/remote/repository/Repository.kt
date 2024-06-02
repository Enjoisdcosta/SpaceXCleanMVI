package com.example.virginmoney.data.repository

import com.example.data.remote.network.capsules.Capsules
import com.example.data.remote.network.capsules.CapsulesItemModel
import kotlinx.coroutines.flow.Flow

import retrofit2.http.GET

interface Repository {
    suspend fun getCapsules(): Flow<List<Capsules?>?>

}