package com.naughtychild.jetpack.viewmodel.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.naughtychild.jetpack.R

class LiveDataActivity : AppCompatActivity() {
    private lateinit var textView: TextView
    lateinit var button: Button
    lateinit var startButton: Button
    lateinit var transformButton: Button
    lateinit var button6: Button

    private lateinit var timerLiveDataModel: TimerLiveDataModel
    private lateinit var typeModel: TransMapViewModel
    private lateinit var countNumViewModel: CountNumViewModel
    private lateinit var countNumTv: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_data)
        typeModel = TransMapViewModel()
        timerLiveDataModel = ViewModelProvider(this).get(TimerLiveDataModel::class.java)
        countNumViewModel = ViewModelProvider(this).get(CountNumViewModel::class.java)
        textView = findViewById(R.id.textView2)
        button = findViewById(R.id.button3)
        startButton = findViewById(R.id.button4)
        transformButton = findViewById(R.id.button5)
        countNumTv = findViewById(R.id.countNumTv)

        button6 = findViewById(R.id.button6)
        button6.setOnClickListener {
            countNumViewModel.senMessage()
        }
        countNumViewModel.liveCombind.observe(this) {
            countNumTv.text = it
        }

        typeModel.mapLiveData.observe(this) {
            Log.d("LiveDataActivity", "onCreate: $it")
        }

        transformButton.setOnClickListener {
            typeModel.sendData()
        }
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