package com.naughtychild.jetpack.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.naughtychild.jetpack.R
import com.naughtychild.jetpack.viewmodel.model.TimerListener
import com.naughtychild.jetpack.viewmodel.model.TimerModel

class ViewModelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_model)
        var textView = findViewById<TextView>(R.id.textView)
        val button = findViewById<Button>(R.id.button2)
        val timeViewModel = ViewModelProvider(this).get(TimerModel::class.java)
        timeViewModel.listener = object : TimerListener {
            override fun listening(currentSecond: Int) {
                runOnUiThread {
                    textView.text = "time :$currentSecond"
                }
            }
        }
        button.setOnClickListener {
            timeViewModel.timing()
        }
    }
}