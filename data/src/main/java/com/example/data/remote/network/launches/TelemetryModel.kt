package com.example.data.remote.network.launches


import com.google.gson.annotations.SerializedName

data class TelemetryModel(
    @SerializedName("flight_club")
    val flightClub: String? = ""
)