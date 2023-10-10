package com.example.progressbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDownload = findViewById<Button>(R.id.btnDownload)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar)

        btnDownload.setOnClickListener {
            if (progressBar.visibility == ProgressBar.INVISIBLE)
                progressBar.visibility = ProgressBar.VISIBLE

            Thread {
                progressBar.progress = 0
                var progressBarStatus = 0
                var rate = 0

                while (progressBarStatus < 100) {
                    try {
                        rate += 10
                        Thread.sleep(500)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                    progressBarStatus = rate
                    progressBar.progress = progressBarStatus
                }
                progressBar.visibility = ProgressBar.INVISIBLE
            }.start()
        }
    }
}