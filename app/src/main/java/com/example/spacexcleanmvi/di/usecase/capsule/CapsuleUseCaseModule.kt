package com.example.spacexcleanmvi.di.usecase.capsule

import com.example.domain.repository.CapsuleRepository
import com.example.domain.usecase.capsule.GetCapsulesByIdUseCase
import com.example.domain.usecase.capsule.GetCapsulesUseCase
import com.example.domain.usecase.UseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class CapsuleUseCaseModule {

    @Provides
    fun provideGetCapsulesUseCase(
        configuration: UseCase.Configuration,
        repository: CapsuleRepository
    ) : GetCapsulesUseCase = GetCapsulesUseCase(
        configuration,
        repository
    )

    @Provides
    fun provideGetCapsuleByIdUseCase(
        configuration: UseCase.Configuration,
        repository: CapsuleRepository
    ) : GetCapsulesByIdUseCase = GetCapsulesByIdUseCase(
        configuration,
        repository
    )
}