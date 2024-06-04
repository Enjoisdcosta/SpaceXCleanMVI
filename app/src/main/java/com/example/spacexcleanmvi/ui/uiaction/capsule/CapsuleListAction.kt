package com.example.spacexcleanmvi.ui.uiaction.capsule

import com.example.common.nav.state.UiAction

sealed class CapsuleListAction: UiAction {

    data object  Load: CapsuleListAction()

    data class OnCapsuleItemClick(
        val capsuleId: String?,
    ) : CapsuleListAction()
}

