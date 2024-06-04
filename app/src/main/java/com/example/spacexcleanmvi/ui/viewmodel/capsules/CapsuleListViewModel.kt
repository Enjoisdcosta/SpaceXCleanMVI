package com.example.spacexcleanmvi.ui.viewmodel.capsules

import androidx.lifecycle.viewModelScope
import com.example.common.nav.NavRoutes
import com.example.common.nav.state.MviViewModel
import com.example.common.nav.state.UiState
import com.example.domain.usecase.capsule.GetCapsulesUseCase
import com.example.spacexcleanmvi.converter.capsule.CapsuleListConverter
import com.example.spacexcleanmvi.ui.model.CapsuleListModel
import com.example.spacexcleanmvi.ui.uiaction.capsule.CapsuleListAction
import com.example.spacexcleanmvi.ui.uiaction.capsule.CapsuleListSingleEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CapsuleListViewModel @Inject constructor(
    private val useCase: GetCapsulesUseCase,
    private val converter: CapsuleListConverter
): MviViewModel<CapsuleListModel, UiState<CapsuleListModel>, CapsuleListAction, CapsuleListSingleEvent>(){


    override fun initState(): UiState<CapsuleListModel> = UiState.Loading

    override fun handleAction(action: CapsuleListAction) {
         when (action) {
             is CapsuleListAction.Load -> {
                 loadCapsules()
             }
             is CapsuleListAction.OnCapsuleItemClick -> {
                 submitSingleEvent(
                     CapsuleListSingleEvent.OpenDetailsScreen(
                        NavRoutes.CapsuleDetails.routeForCapsule(
                            NavRoutes.CapsuleInput(
                                action.capsuleId,
                            )
                        )
                     )
                 )

             }
         }


    }

    private fun loadCapsules() {
        viewModelScope.launch {
            useCase.execute(GetCapsulesUseCase.Request)
                .map {
                    converter.convert(it)
                }
                .collect{
                    submitState(it)
                }
        }
    }
}