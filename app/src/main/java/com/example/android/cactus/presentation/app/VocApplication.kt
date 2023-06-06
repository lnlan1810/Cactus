package com.example.android.cactus.presentation.app

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import com.example.android.cactus.presentation.modules.databaseModule
import com.example.android.cactus.presentation.modules.dispatcherModule
import com.example.android.cactus.presentation.modules.repositoryModule
import com.example.android.cactus.presentation.modules.viewModelModule
import com.example.android.cactus.domain.utils.MemoBroadcast
import dagger.hilt.android.HiltAndroidApp
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.*

@HiltAndroidApp
class VocApplication : Application() {

    private val CHANNEL_ID = "mainChannelId"
    val CHANNEL_NAME = "mainChannelName"

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@VocApplication)
            modules(databaseModule, repositoryModule, viewModelModule, dispatcherModule)
        }

        createNotificationChannel()
       // setRepeatingNotification()
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.YELLOW
                enableLights(true)
            }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }

    /*private fun setRepeatingNotification() {
        val calendar = Calendar.getInstance()

        with(calendar) {
            set(Calendar.HOUR_OF_DAY, 18)
            set(Calendar.MINUTE, 0)
            set(Calendar.SECOND, 0)

            if (Calendar.getInstance().after(this)) {
                calendar.add(Calendar.DAY_OF_MONTH, 1)
            }
        }

        val intent = Intent(this, MemoBroadcast::class.java)

        val pendingIntent = PendingIntent.getBroadcast(
            applicationContext,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            calendar.timeInMillis,
            AlarmManager.INTERVAL_DAY,
            pendingIntent
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            alarmManager.setExactAndAllowWhileIdle(
                AlarmManager.RTC_WAKEUP,
                calendar.timeInMillis,
                pendingIntent
            )
        }
    }*/
}