package com.aeps.serverdrivenuiwithfirestore.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aeps.serverdrivenuiwithfirestore.component.DataState
import com.aeps.serverdrivenuiwithfirestore.domain.SduiUseCase
import com.aeps.serverdrivenuiwithfirestore.domain.model.ServerDrivenUiEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ServerDrivenUiViewModel @Inject constructor(
    private val sduiUseCase: SduiUseCase

) : ViewModel() {
    var sduiResponse by mutableStateOf<DataState<List<ServerDrivenUiEntity>>>(DataState.Loading)
        private set
    var aadharNo: MutableState<String> = mutableStateOf(value = "")
        private set

    var vidNo: MutableState<String> = mutableStateOf(value = "")
        private set

    init {
        getSdui()
    }

    fun updateAadharNo(newValue: String) {
        aadharNo.value = newValue
    }
    fun updateVid(newValue: String) {
        vidNo.value = newValue
    }

    private fun getSdui() = viewModelScope.launch {
        sduiUseCase.invoke().collect { response ->
            sduiResponse = response
        }
    }
}