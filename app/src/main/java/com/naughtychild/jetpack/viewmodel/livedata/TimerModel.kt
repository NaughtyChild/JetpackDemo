package com.naughtychild.jetpack.viewmodel.livedata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class TimerLiveDataModel : ViewModel() {
    private val mutableLiveData = MutableLiveData<Int>()
    private val timer: Timer = Timer()
    private var currentSecond = 0
    fun timing() {
        currentSecond = 0
        mutableLiveData.value=currentSecond
        val timerTask = object : TimerTask() {
            override fun run() {
                currentSecond++
                mutableLiveData.postValue(currentSecond)
            }
        }
        timer.schedule(timerTask, 1000, 1000)
    }

    fun getCurrentData(): MutableLiveData<Int> {
        return mutableLiveData
    }

    override fun onCleared() {
        timer.cancel()
    }
}