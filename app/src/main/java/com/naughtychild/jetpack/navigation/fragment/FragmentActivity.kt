package com.naughtychild.jetpack.navigation.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.naughtychild.jetpack.R

class FragmentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
    }
}