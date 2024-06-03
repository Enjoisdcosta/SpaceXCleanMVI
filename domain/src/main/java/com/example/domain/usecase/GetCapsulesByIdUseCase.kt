package com.example.domain.usecase

import com.example.domain.entity.Capsules
import com.example.domain.repo.CapsuleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCapsulesByIdUseCase(
    configuration: Configuration,
    private val repo: CapsuleRepository
) : UseCase<GetCapsulesByIdUseCase.Request, GetCapsulesByIdUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getCapsule(request.capsulesId)
            .map {
                Response(it)
            }

    data class Request(val capsulesId: Int?) : UseCase.Request
    data class Response(val movie: Capsules?) : UseCase.Response
}