package com.example.spacexcleanmvi.converter.capsule

import android.content.Context
import com.example.common.nav.state.CommonResultConverter
import com.example.domain.usecase.capsule.GetCapsulesUseCase
import com.example.spacexcleanmvi.ui.model.Capsule
import com.example.spacexcleanmvi.ui.model.CapsuleListModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CapsuleListConverter @Inject constructor(
    @ApplicationContext private val context: Context
) : CommonResultConverter<GetCapsulesUseCase.Response, CapsuleListModel>() {


    override fun convertSuccess(
        data: GetCapsulesUseCase.Response
    )
            : CapsuleListModel {
        return CapsuleListModel(
            items = data.capsules?.map {
                Capsule(
                    capsuleId = it?.capsuleId,
                    details = it?.details,
                    originalLaunch = it?.originalLaunch,
                    status = it?.status,
                    landings = it?.landings,
                )
            } ?: listOf()
        )
    }


}