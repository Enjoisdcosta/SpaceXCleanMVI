package com.example.data.source

import com.example.data.remote.api.APIEndpoints
import com.example.data.remote.network.capsules.CapsulesItemModel
import com.example.data.remote.repository.RemoteCapsuleDataSource
import com.example.domain.entity.Capsule
import com.example.domain.entity.UseCaseException
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteCapsuleDataSourceImpl @Inject constructor(
    private val service: APIEndpoints
) : RemoteCapsuleDataSource {

    override fun getCapsules(): Flow<List<Capsule?>?> = flow {
        val capsules = service.getCapsules()
        emit(capsules)
    }.map { capsuleList ->
        capsuleList.map { capsule -> convert(capsule) }
    }.catch {
        throw UseCaseException.CapsuleException(it)
    }

    override fun getCapsule(id: String?): Flow<Capsule> = flow{
        emit(service.getCapsuleById(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.CapsuleException(it)
    }

    private fun convert(model: CapsulesItemModel): Capsule {
        return Capsule(
            capsuleId = model?.capsuleId,
            details = model?.details,
            originalLaunch = model?.originalLaunch,
            status = model?.status,
        )
    }
}


