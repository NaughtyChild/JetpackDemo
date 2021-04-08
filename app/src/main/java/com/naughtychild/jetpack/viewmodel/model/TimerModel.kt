package com.naughtychild.jetpack.viewmodel.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*

class TimerModel : ViewModel() {
    private val timer: Timer = Timer()
    private var currentSecond = 0
    var listener: TimerListener? = null
    fun timing() {
        currentSecond = 0
        val timerTask = object : TimerTask() {
            override fun run() {
                currentSecond++
                if (listener != null) {
                    listener?.listening(currentSecond)
                }
            }
        }
        timer.schedule(timerTask, 1000, 1000)
    }

    override fun onCleared() {
        timer.cancel()
    }
}

interface TimerListener {
    fun listening(currentSecond: Int)
}