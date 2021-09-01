package com.naughtychild.jetpack.viewmodel.flow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FlowViewModel : ViewModel() {
    var count = 1
    val mutalStateFlow = MutableStateFlow(count)
    val stateFlow: StateFlow<Int> = mutalStateFlow
    fun changeNum() {
        viewModelScope.launch {
            mutalStateFlow.value = count
            count++
        }
    }
}
