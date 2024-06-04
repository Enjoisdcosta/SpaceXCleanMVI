package com.example.data.remote.api


import com.example.data.remote.api.APIDetail.HISTORY_BY_ID_ENDPOINT
import com.example.data.remote.api.APIDetail.HISTORY_ENDPOINT
import com.example.data.remote.network.capsules.CapsulesItemModel
import com.example.data.remote.network.history.HistoryItemModel
import com.example.domain.repository.HistoryRepository
import retrofit2.http.GET



interface APIEndpoints {

    @GET(APIDetail.CAPSULES_ENDPOINT)
    suspend fun getCapsules(): List<CapsulesItemModel>

    @GET(APIDetail.CAPSULE_BY_ID_ENDPOINT)
    suspend fun getCapsuleById(id: String?): CapsulesItemModel


    @GET(HISTORY_ENDPOINT)
    suspend fun getHistory(): List<HistoryItemModel>

    @GET(HISTORY_BY_ID_ENDPOINT)
    suspend fun getHistoryItem(id: Int?): HistoryItemModel





}