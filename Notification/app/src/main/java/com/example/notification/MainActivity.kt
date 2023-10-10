package com.example.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.core.app.NotificationCompat

class MainActivity : AppCompatActivity() {

    private val CHANNEL_ID = "ChannelNews"
    private val CHANNEL_NAME = "News"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnShowNotification = findViewById<Button>(R.id.btnShowNotification)
        btnShowNotification.setOnClickListener {
            /*createNotificationChannel()
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val notification: Notification = Notification.Builder(this, CHANNEL_ID)
                    .setSmallIcon(R.drawable.computer_24)
                    .setContentTitle("Android Notification")
                    .setContentText("Check News")
                    .build()

                val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
                notificationManager.notify(0, notification)
            }*/


            createNotificationChannel()

            val intent = Intent(this, ResultActivity::class.java).apply {
                putExtra("Test", "Notify")
            }

            val pendingIntent: PendingIntent =
                PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_MUTABLE)

            val notification: Notification = NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.computer_24)
                .setContentTitle("Android Notification")
                .setContentText("Check News")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)
                .build()

            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.notify(0, notification)

        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val notifyChannel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance).apply {
                description = "Test Description"
                enableLights(true)
                lightColor = Color.RED
                enableVibration(true)
            }
            val notifyManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            notifyManager.createNotificationChannel(notifyChannel)
        }
    }
}