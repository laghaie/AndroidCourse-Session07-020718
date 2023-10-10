package com.example.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        if (intent.hasExtra("Test")) {
            val value = intent.getStringExtra("Test")
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()
        }
    }
}