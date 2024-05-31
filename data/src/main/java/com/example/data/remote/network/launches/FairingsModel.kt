package com.example.data.remote.network.launches


import com.google.gson.annotations.SerializedName

data class FairingsModel(
    @SerializedName("recovered")
    val recovered: Boolean? = false,
    @SerializedName("recovery_attempt")
    val recoveryAttempt: Boolean? = false,
    @SerializedName("reused")
    val reused: Boolean? = false,
    @SerializedName("ship")
    val ship: String? = ""
)