package com.example.domain.entity.history


data class History(
    val details: String? = "",
    val eventDateUnix: Int? = 0,
    val eventDateUtc: String? = "",
    val flightNumber: Int? = 0,
    val id: Int? = 0,
    val title: String? = ""
)