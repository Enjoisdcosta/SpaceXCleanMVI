package com.example.data.remote.di


import com.example.data.remote.api.APIDetail
import com.example.data.remote.api.APIEndpoints
import com.example.data.remote.api.RetrofitInstance
import com.example.data.remote.domain.FetchDataUseCase
import com.example.data.remote.repository.CapsuleRepository
import com.example.data.remote.repository.CapsuleRepositoryImplementaion
import com.example.virginmoney.data.repository.Repository
import com.example.virginmoney.data.repository.RepositoryImplementaion
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    fun gson(): Gson{
        return  Gson()
    }
    @Provides
    fun loggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    @Provides
    fun covertor(gson: Gson) = GsonConverterFactory.create()


    @Provides
    fun provideOkHttpClient(
        logging: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit = Retrofit.Builder()
        .baseUrl(APIDetail.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()

    @Provides
    fun apiInstance(retrofit: Retrofit): APIEndpoints = retrofit.create(APIEndpoints::class.java)

    @Provides
    fun providesRepository(apiEndpoints: APIEndpoints): Repository {
        return RepositoryImplementaion(apiEndpoints)
    }


    @Provides
    fun provideApiService(): APIEndpoints {
        return RetrofitInstance.api
    }

    @Provides
    fun provideDataRepository(apiService: APIEndpoints): CapsuleRepository {
        return CapsuleRepositoryImplementaion(apiService)
    }

    @Provides
    fun provideFetchDataUseCase(repository: CapsuleRepository): FetchDataUseCase {
        return FetchDataUseCase(repository)
    }
}