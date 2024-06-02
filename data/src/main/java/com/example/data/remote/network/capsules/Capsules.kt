package com.example.data.remote.network.capsules


import com.google.gson.annotations.SerializedName


data class Capsules(

    val capsuleId: String? = "",
    val capsuleSerial: String? = "",
    val details: String? = "",
    val landings: Int? = 0,
    val originalLaunch: String? = "",
    val originalLaunchUnix: Int? = 0,
    val reuseCount: Int? = 0,
    val status: String? = "",
    val type: String? = ""

)