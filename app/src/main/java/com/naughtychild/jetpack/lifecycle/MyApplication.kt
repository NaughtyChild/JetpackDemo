package com.naughtychild.jetpack.lifecycle

import android.app.Application
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.ProcessLifecycleOwner

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        ProcessLifecycleOwner.get().lifecycle.addObserver(ApplicationObserver())
    }
}

class ApplicationObserver : LifecycleObserver {
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun onCreate() {
        Log.d("ApplicationObserver", "onCreate: ")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private fun onStart() {
        Log.d("ApplicationObserver", "onStart: ")
    }
}