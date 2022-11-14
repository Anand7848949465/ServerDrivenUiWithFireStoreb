package com.aeps.serverdrivenuiwithfirestore.domain.repository

import com.aeps.serverdrivenuiwithfirestore.component.DataState
import com.aeps.serverdrivenuiwithfirestore.domain.model.KeyValueEntity
import com.aeps.serverdrivenuiwithfirestore.domain.model.ServerDrivenUiEntity
import kotlinx.coroutines.flow.Flow


typealias KeyValueEntityType = List<KeyValueEntity>
//typealias KeyValueEntityResponse = DataState<ServerDrivenUiEntity>

interface ServerDrivenUiRepository {
    suspend fun getServerDrivenUiData(): Flow<DataState<List<ServerDrivenUiEntity>>>
}