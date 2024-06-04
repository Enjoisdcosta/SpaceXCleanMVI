package com.example.spacexcleanmvi.ui.uiaction.history

import com.example.common.nav.state.UiAction

sealed class HistoryListAction: UiAction {

    data object  Load: HistoryListAction()

    data class OnHistoryItemClick(
        val id: String?,
    ) : HistoryListAction()
}

