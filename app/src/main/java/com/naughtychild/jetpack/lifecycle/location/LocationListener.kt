package com.naughtychild.jetpack.lifecycle.location

import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LocationListener constructor(context: Context, listener: LocationChangeListener) :
    LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun startLocation() {
        Log.d("LocationListener", "startLocation: ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private fun pauseLocation() {
        Log.d("LocationListener", "pauseLocation: ")
    }
}

interface LocationChangeListener {
    fun locationChange()
}