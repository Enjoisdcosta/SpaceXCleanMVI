package com.example.data.source.history

import com.example.data.remote.api.APIEndpoints
import com.example.data.remote.network.capsules.CapsulesItemModel
import com.example.data.remote.network.history.HistoryItemModel
import com.example.data.remote.repository.capsule.RemoteCapsuleDataSource
import com.example.data.remote.repository.history.RemoteHistoryDataSource
import com.example.domain.entity.capsule.Capsule
import com.example.domain.entity.UseCaseException
import com.example.domain.entity.history.History
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RemoteHistoryDataSourceImpl @Inject constructor(
    private val service: APIEndpoints
) : RemoteHistoryDataSource {

    override fun getHistory(): Flow<List<History?>?> = flow {
        val history = service.getHistory()
        emit(history)
    }.map { capsuleList ->
        capsuleList.map { history -> convert(history) }
    }.catch {
        throw UseCaseException.SpaceXException(it)
    }

    override fun getHistoryItem(id: Int?): Flow<History> = flow{
        emit(service.getHistoryItem(id))
    }.map {
        convert(it)
    }.catch {
        throw UseCaseException.SpaceXException(it)
    }

    private fun convert(model: HistoryItemModel): History {
        return History(
            id = model.id,
            details = model.details,
            title = model.title,
            eventDateUtc = model.eventDateUtc,
            flightNumber = model.flightNumber,

        )
    }


}


