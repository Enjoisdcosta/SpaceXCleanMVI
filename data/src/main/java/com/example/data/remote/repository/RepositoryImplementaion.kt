package com.example.virginmoney.data.repository


import com.example.data.remote.api.APIEndpoints
import com.example.data.remote.network.capsules.Capsules
import com.example.data.remote.network.capsules.CapsulesItemModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RepositoryImplementaion @Inject constructor(
    private val apiDetail: APIEndpoints
) :Repository {
    override suspend fun getCapsules(): Flow<List<CapsulesItemModel>> {
        return apiDetail.getCapsules()

    }


}