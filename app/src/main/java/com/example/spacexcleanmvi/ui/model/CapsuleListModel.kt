package com.example.spacexcleanmvi.ui.model

//return Capsule(
//capsuleId = model?.capsuleId,
//details = model?.details,
//originalLaunch = model?.originalLaunch,
//status = model?.status,
//)
//
//
data class CapsuleListModel(
    val items: List<Capsule> = listOf()
)

data class Capsule(
    val capsuleId: String? = "",
    val details: String? = "",
    val originalLaunch: String? = "",
    val status: String? = ""

)