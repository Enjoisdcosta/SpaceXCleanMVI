package com.example.data.remote.network.launches


import com.google.gson.annotations.SerializedName

data class LaunchFailureDetailsModel(
    @SerializedName("altitude")
    val altitude: Int? = 0,
    @SerializedName("reason")
    val reason: String? = "",
    @SerializedName("time")
    val time: Int? = 0
)