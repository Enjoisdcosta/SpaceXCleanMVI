package com.example.spacexcleanmvi.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.remote.domain.FetchDataUseCase
import com.example.data.remote.network.capsules.CapsulesItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val fetchDataUseCase: FetchDataUseCase
): ViewModel() {

    private val _state = MutableStateFlow(emptyFlow<List<CapsulesItemModel?>?>())
    val state: MutableStateFlow<Flow<List<CapsulesItemModel?>?>> = _state

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            val data = fetchDataUseCase()
            if (data != null) {
                _state.value = data
            }
        }
    }
}