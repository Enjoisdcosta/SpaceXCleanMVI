package com.example.spacexcleanmvi.ui.model

//return Capsule(
//capsuleId = model?.capsuleId,
//details = model?.details,
//originalLaunch = model?.originalLaunch,
//status = model?.status,
//)
//
//
data class HistoryListModel(
    val items: List<History> = listOf()
)

data class History(
    val id: Int? =  0,
    val details: String? = "",
    val title: String? = "",
    val eventDateUtc: String? = "",
    val flightNumber: Int? = 0

)
