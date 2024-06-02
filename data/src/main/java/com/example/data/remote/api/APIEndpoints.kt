package com.example.data.remote.api


import com.example.data.remote.network.capsules.Capsules
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET



interface APIEndpoints {

    @GET(APIDetail.CAPSULES_ENDPOINT)
    suspend fun getCapsules(): Flow<List<Capsules?>?>




}