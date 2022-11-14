package com.aeps.serverdrivenuiwithfirestore.data.repository

import android.util.Log
import com.aeps.serverdrivenuiwithfirestore.component.DataState
import com.aeps.serverdrivenuiwithfirestore.domain.model.ServerDrivenUiEntity
import com.aeps.serverdrivenuiwithfirestore.domain.repository.ServerDrivenUiRepository
import com.google.firebase.firestore.CollectionReference
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class ServerDrivenUiRepositoryImpl @Inject constructor(
    private val sduiRef: CollectionReference
) : ServerDrivenUiRepository {
    override suspend fun getServerDrivenUiData(): Flow<DataState<List<ServerDrivenUiEntity>>> =
        callbackFlow {
            val snapshotListener = sduiRef.addSnapshotListener { snapshot, e ->
                val sduiResponse = if (snapshot != null) {
                    val sdui = snapshot.toObjects(ServerDrivenUiEntity::class.java)
                    Log.d("firedata", snapshot.documents.toString())
                    DataState.Success(sdui)
                } else {
                    DataState.Error(e)
                }
                trySend(sduiResponse)
            }
            awaitClose {
                snapshotListener.remove()
            }
        }

}