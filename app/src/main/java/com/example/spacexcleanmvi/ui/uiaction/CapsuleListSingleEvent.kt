package com.example.spacexcleanmvi.ui.uiaction

import com.example.common.nav.state.UiSingleEvent

sealed class CapsuleListSingleEvent: UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String): CapsuleListSingleEvent()
}