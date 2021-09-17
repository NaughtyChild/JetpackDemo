package com.naughtychild.jetpack.viewmodel.flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ForegroundColorSpan
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.PermissionChecker
import androidx.lifecycle.*
import com.naughtychild.jetpack.R
import com.naughtychild.jetpack.databinding.ActivityFlowBinding
import com.naughtychild.jetpack.util.SpanBuilder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FlowActivity : AppCompatActivity() {
    val button by lazy<Button> {
        findViewById(R.id.button)
    }
    val content by lazy<TextView> {
        findViewById(R.id.content)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var flowBinding = ActivityFlowBinding.inflate(layoutInflater)
        setContentView(flowBinding.root)
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
        val testStr = "123456789"

        var span = SpannableString(testStr)
        //start 和end 的索引总是包左不包右
        span.setSpan(
            ForegroundColorSpan(resources.getColor(R.color.teal_200)),
            4,
            6, Spanned.SPAN_INCLUSIVE_EXCLUSIVE
        )
    }

    val TAG = "FlowActivity"
    fun testClick(view: android.view.View) {
        lifecycleScope.launch {
            withContext(Dispatchers.Default) {
                Log.d(TAG, "testClick: ${Thread.currentThread().name}")
                flow<Int> {
                    var i = 0
                    repeat(2) {
                        delay(1000)
                        i++
                        emit(i)
                    }
                }.map {
                    Log.d(TAG, "map1: $it,threadName=${Thread.currentThread().name}")
                    it
                }.flowOn(Dispatchers.IO).map {
                    Log.d(TAG, "map2:$it,threadName=${Thread.currentThread().name} ")
                    it
                }.flowOn(Dispatchers.Main).collect {
                    Log.d(TAG, "collect: $it,threadName=${Thread.currentThread().name}")
                }
            }

        }
    }

}