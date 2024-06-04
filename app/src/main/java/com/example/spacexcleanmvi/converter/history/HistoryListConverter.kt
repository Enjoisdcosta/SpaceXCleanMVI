package com.example.spacexcleanmvi.converter.history

import android.content.Context
import com.example.common.nav.state.CommonResultConverter
import com.example.domain.usecase.capsule.GetCapsulesUseCase
import com.example.domain.usecase.history.GetHistoryUseCase
import com.example.spacexcleanmvi.ui.model.Capsule
import com.example.spacexcleanmvi.ui.model.CapsuleListModel
import com.example.spacexcleanmvi.ui.model.History
import com.example.spacexcleanmvi.ui.model.HistoryListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class HistoryListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetHistoryUseCase.Response, HistoryListModel>() {


    override fun convertSuccess(
        data: GetHistoryUseCase.Response
    )
            : HistoryListModel {
        return HistoryListModel(
            items = data.history?.map {
                History(
                    id = it?.id,
                    details = it?.details,
                    title = it?.title,
                    eventDateUtc = it?.eventDateUtc,
                    flightNumber = it?.flightNumber,
                )
            } ?: listOf()
        )
    }




}