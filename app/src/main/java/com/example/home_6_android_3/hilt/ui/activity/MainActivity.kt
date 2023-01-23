package com.example.home_6_android_3.hilt.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.home_6_android_3.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}