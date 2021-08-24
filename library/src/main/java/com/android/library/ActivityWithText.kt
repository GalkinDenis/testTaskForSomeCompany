package com.android.library

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.android.library.databinding.ActivityWithTextBinding

class ActivityWithText: AppCompatActivity() {

    private var _binding: ActivityWithTextBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWithTextBinding.inflate(layoutInflater)
        setContentView(_binding?.root)
        binding.textView.text = intent.getStringExtra("key")
    }

    override fun onResume() {
        super.onResume()
        Log.d("activityState", "ActivityWithText onOpen")
    }

    override fun onPause() {
        super.onPause()
        Log.d("activityState", "ActivityWithText onClosed")
    }
}