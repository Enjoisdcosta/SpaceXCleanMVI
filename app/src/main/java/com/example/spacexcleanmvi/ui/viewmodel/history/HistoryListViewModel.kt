//package com.example.spacexcleanmvi.ui.viewmodel.history
//
//import androidx.lifecycle.viewModelScope
//import com.example.common.nav.NavRoutes
//import com.example.common.nav.state.MviViewModel
//import com.example.common.nav.state.UiState
//import com.example.domain.usecase.history.GetHistoryUseCase
//import com.example.spacexcleanmvi.converter.history.HistoryListConverter
//import com.example.spacexcleanmvi.ui.model.HistoryListModel
//import com.example.spacexcleanmvi.ui.uiaction.history.HistoryListAction
//import com.example.spacexcleanmvi.ui.uiaction.history.HistoryListSingleEvent
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.map
//import kotlinx.coroutines.launch
//import javax.inject.Inject
//
//@HiltViewModel
//class HistoryListViewModel @Inject constructor(
//    private val useCase: GetHistoryUseCase,
//    private val converter: HistoryListConverter
//): MviViewModel<HistoryListModel, UiState<HistoryListModel>, HistoryListAction, HistoryListSingleEvent>() {
//    override fun initState(): UiState<HistoryListModel> = UiState.Loading
//
//    override fun handleAction(action: HistoryListAction) {
//        when (action) {
//            is HistoryListAction.Load -> {
//                loadHistory()
//            }
//            is HistoryListAction.OnHistoryItemClick -> {
//                submitSingleEvent(
//                    HistoryListSingleEvent.OpenDetailsScreen(
//                                NavRoutes.HistoryDetails.routeForHistory(
//                                    NavRoutes.HistoryInput(
//                                        action.id,
//                                        action.title
//                                    )
//                                )
//                    ))
//
//
//            }
//        }
//    }
//
//    private fun loadHistory() {
//        viewModelScope.launch {
//            useCase.execute(GetHistoryUseCase.Request)
//                .map {
//                    converter.convert(it)
//                }
//                .collect {
//                    submitState(it)
//                }
//        }
//    }
//
//
//}