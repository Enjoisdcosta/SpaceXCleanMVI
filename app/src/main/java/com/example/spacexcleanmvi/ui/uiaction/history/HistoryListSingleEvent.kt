package com.example.spacexcleanmvi.ui.uiaction.history

import com.example.common.nav.state.UiSingleEvent

sealed class HistoryListSingleEvent : UiSingleEvent {

    data class OpenDetailsScreen(val navRoute: String) : HistoryListSingleEvent()
}