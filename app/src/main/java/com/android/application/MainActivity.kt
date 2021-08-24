package com.android.application

import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.android.application.databinding.ActivityMainBinding
import com.android.library.ActivityWithLoadText

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    @RequiresApi(Build.VERSION_CODES.P)
    private val getContent = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        val source: ImageDecoder.Source? =
            uri?.let { ImageDecoder.createSource(applicationContext.contentResolver, it) }
        binding.image.setImageBitmap(source?.let { ImageDecoder.decodeBitmap(it) })
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(_binding?.root)

        binding.button.setOnClickListener {
            ActivityWithLoadText().loadText(
                this,
                binding.editView.text.toString(),
                "key",
                "ActivityWithTex"
            )
        }

        binding.button2.setOnClickListener {
            ActivityWithLoadText().loadImage(getContent)
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("activityState", "MainActivity onOpen")
    }

    override fun onPause() {
        super.onPause()
        Log.d("activityState", "MainActivity onClosed")
    }
}