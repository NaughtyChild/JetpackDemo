package com.naughtychild.jetpack.viewmodel.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.*
import com.naughtychild.jetpack.R
import com.naughtychild.jetpack.viewmodel.model.TimerModel
import kotlinx.coroutines.flow.collect

class FlowActivity : AppCompatActivity() {
    val button by lazy<Button> {
        findViewById(R.id.button)
    }
    val content by lazy<TextView> {
        findViewById(R.id.content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flow)
        val flowModel = ViewModelProvider(this).get(FlowViewModel::class.java)

        button.setOnClickListener {
            flowModel.changeNum()
        }

        lifecycleScope.launchWhenCreated {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                flowModel.stateFlow.collect {
                    content.text = it.toString()
                }
            }
        }
    }
}