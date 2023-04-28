package com.example.android.cactus.domain.utils

import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.android.cactus.R
import com.example.android.cactus.presentation.ui.category.VocabularyNotebookFragment

class MemoBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {

        val NOTIFICATION_ID = 200

        val intent = Intent(context, VocabularyNotebookFragment ::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP

        //pendingIntent is to give permission to other apps or other system services
        // to use piece of code of our app (like starting an activity)
        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT
        )

        //create Notification
        val builder =
            NotificationCompat.Builder(context, context.getString(R.string.main_channel_id))
                .setContentTitle(context.getString(R.string.Notification_title))
                .setContentText(context.getString(R.string.Notification_text))
                .setSmallIcon(R.drawable.ic_baseline_sentiment_very_satisfied_24)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent)
                .setAutoCancel(true)

        val notificationManager = NotificationManagerCompat.from(context)

        notificationManager.notify(NOTIFICATION_ID, builder.build())
    }

    private fun createNotification() {

    }
}