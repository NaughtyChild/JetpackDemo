package com.naughtychild.jetpack.viewmodel.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naughtychild.jetpack.R

class LiveDataActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    lateinit var button: Button
    lateinit var startButton: Button
    private lateinit var timerLiveDataModel: TimerLiveDataModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        textView = findViewById(R.id.textView2)
        button = findViewById(R.id.button3)
        startButton = findViewById(R.id.button4)
        timerLiveDataModel = ViewModelProvider(this).get(TimerLiveDataModel::class.java)
        val liveData = timerLiveDataModel.getCurrentData()
        liveData.observe(this) {
            runOnUiThread {
                textView.text = "time =$it"
            }
        }
        button.setOnClickListener {
            liveData.value = 0
        }
        startButton.setOnClickListener {
            timerLiveDataModel.timing()
        }
    }
}