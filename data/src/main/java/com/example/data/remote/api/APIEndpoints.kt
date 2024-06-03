package com.example.data.remote.api


import com.example.data.remote.network.capsules.CapsulesItemModel
import retrofit2.http.GET



interface APIEndpoints {

    @GET(APIDetail.CAPSULES_ENDPOINT)
    suspend fun getCapsules(): List<CapsulesItemModel>

    @GET(APIDetail.CAPSULE_BY_ID_ENDPOINT)
    suspend fun getCapsuleById(id: String?): CapsulesItemModel





}