package com.android.library

import android.content.Context
import android.content.Intent
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity

class ActivityWithLoadText: AppCompatActivity() {

    fun loadText(context: Context, word: String, keyActivity: String, nameActivity: String) {
        val intent = Intent(nameActivity)
        intent.putExtra(keyActivity, word)
        context.startActivity(intent)
    }

    fun loadImage(getContent: ActivityResultLauncher<String>) {
        getContent.launch("image/*")
    }
}