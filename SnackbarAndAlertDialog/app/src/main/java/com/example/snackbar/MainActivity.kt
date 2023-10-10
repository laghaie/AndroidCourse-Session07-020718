package com.example.snackbar

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.Button
import android.widget.FrameLayout
import androidx.core.view.ViewCompat
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_INDEFINITE
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private val TAG: String = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowMessage = findViewById<Button>(R.id.btnShowMessage)
        btnShowMessage.setOnClickListener { v ->
            //LENGTH_LONG = 3.5 sec
            //LENGTH_SHORT = 2 sec
            //LENGTH_INDEFINITE = Infinity
            /*Snackbar.make(v, "Your Email has been sent successfully", Snackbar.LENGTH_LONG)
                .setAction("OK") {
                    Log.d(TAG, "onCreate: Ok action")
                }
                .setBackgroundTint(Color.WHITE)
                .setActionTextColor(Color.RED)
                .setTextColor(Color.BLACK)
                .show()*/



            /*val snackbar = Snackbar.make(v, "Message", Snackbar.LENGTH_LONG)
            val snackbarView = snackbar.view

            val layoutParams = FrameLayout.LayoutParams(MATCH_PARENT, 175)
            layoutParams.gravity = Gravity.TOP

            snackbarView.layoutParams = layoutParams

            snackbar.setAction("Action") {

            }

            ViewCompat.setLayoutDirection(snackbar.view, ViewCompat.LAYOUT_DIRECTION_RTL)

            snackbar.show()*/


            val snackbar = Snackbar.make(v, "My Message", LENGTH_INDEFINITE)
            val runnable = Runnable {
                snackbar.setAction("Action") {

                }
                snackbar.show()
                Handler(Looper.getMainLooper()).postDelayed({
                    snackbar.dismiss()
                }, 5000) //5000 = 5 sec
            }
            runnable.run()
        }
    }
}