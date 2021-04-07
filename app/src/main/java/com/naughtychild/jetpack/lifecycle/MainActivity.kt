package com.naughtychild.jetpack.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.naughtychild.jetpack.R
import com.naughtychild.jetpack.lifecycle.location.LocationChangeListener
import com.naughtychild.jetpack.lifecycle.location.LocationListener

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val locationListener= LocationListener(this, object : LocationChangeListener {
            override fun locationChange() {
                Log.d("MainActivity", "locationChange: ")
            }
        })
        lifecycle.addObserver(locationListener)
    }
}