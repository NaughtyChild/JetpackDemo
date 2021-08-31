package com.naughtychild.jetpack.viewmodel.flow

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FlowViewModel : ViewModel() {
    var count = 1
    val mutalStateFlow = MutableStateFlow(count)
    val stateFlow: StateFlow<Int> = mutalStateFlow
    fun changeNum() {
        mutalStateFlow.value = count
        count++
    }
}
