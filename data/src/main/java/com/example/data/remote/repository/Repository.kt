package com.example.virginmoney.data.repository

import com.example.data.remote.network.capsules.CapsulesItemModel

import retrofit2.http.GET

interface Repository {
    suspend fun getCapsules(): ArrayList<CapsulesItemModel>

}