package com.example.data.remote.network.launches


import com.google.gson.annotations.SerializedName

data class FirstStageModel(
    @SerializedName("cores")
    val cores: List<CoreModel?>? = listOf()
)