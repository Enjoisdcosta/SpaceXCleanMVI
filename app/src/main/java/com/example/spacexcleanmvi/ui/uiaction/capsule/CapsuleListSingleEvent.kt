package com.example.spacexcleanmvi.ui.uiaction.capsule

import com.example.common.nav.state.UiSingleEvent
import com.example.spacexcleanmvi.ui.uiaction.history.HistoryListSingleEvent

sealed class CapsuleListSingleEvent: UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String): CapsuleListSingleEvent()

}