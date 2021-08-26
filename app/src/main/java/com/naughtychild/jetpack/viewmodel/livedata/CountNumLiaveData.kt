package com.naughtychild.jetpack.viewmodel.livedata

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CountNumViewModel : ViewModel() {
    val liveData = MutableLiveData<String>()
    val liveCombind = MediatorLiveData<String>()
    var number: Int = 1

    init {
        liveCombind.addSource(liveData) {
            check()
        }
    }

    fun senMessage() {
        number++
        liveData.value = number.toString()
    }

    private fun check() {

        if (number > 10) {
            liveCombind.value = "您已经点击${number}次了"
        }
    }
}