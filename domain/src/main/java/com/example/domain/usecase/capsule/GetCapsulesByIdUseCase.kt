package com.example.domain.usecase.capsule

import com.example.domain.entity.Capsule
import com.example.domain.repository.CapsuleRepository
import com.example.domain.usecase.UseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetCapsulesByIdUseCase(
    configuration: Configuration,
    private val repo: CapsuleRepository
) : UseCase<GetCapsulesByIdUseCase.Request, GetCapsulesByIdUseCase.Response>(configuration) {

    override fun process(request: Request): Flow<Response> =
        repo.getCapsuleById(request.capsulesId)
            .map {
                Response(it)
            }

    data class Request(val capsulesId: String?) : UseCase.Request
    data class Response(val capsule: Capsule?) : UseCase.Response
}