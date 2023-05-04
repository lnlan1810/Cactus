package com.example.android.cactus.presentation.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.navigation.NavDeepLinkBuilder
import com.example.android.cactus.presentation.activity.MainActivity
import com.example.android.cactus.R
import com.example.android.cactus.domain.repository.ConversationRepository


private const val CHANNEL_ID = "channel_id_2"

class NotificationService(
    private val context: Context
){
    private var builder:NotificationCompat.Builder

    private  val manager by lazy{
        context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    }
    init{
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel(
                CHANNEL_ID,
                context.getString(R.string.notification_channel_title),
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                description =  context.getString(R.string.notification_channel_desc)

            }.also {
                manager.createNotificationChannel(it)
            }
        }
        val previous = Intent(context, ConversationService::class.java).apply {
            action = "PREVIOUS"
        }

        val pause = Intent(context, ConversationService::class.java).apply {
            action = "PAUSE"
        }

        val next = Intent(context, ConversationService::class.java).apply {
            action = "NEXT"
        }

        val prevIntent = PendingIntent.getService(
            context,
            0,
            previous,
            PendingIntent.FLAG_IMMUTABLE
        )

        val pauseIntent = PendingIntent.getService(
            context,
            1,
            pause,
            PendingIntent.FLAG_IMMUTABLE

        )

        val nextIntent = PendingIntent.getService(
            context,
            2,
            next,
            PendingIntent.FLAG_IMMUTABLE
        )
        builder = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_baseline_play_arrow_24)
            .addAction(R.drawable.ic_baseline_skip_previous_24, "PREVIOUS", prevIntent)
            .addAction(R.drawable.ic_baseline_pause_24, "PAUSE", pauseIntent)
            .addAction(R.drawable.ic_baseline_skip_next_24, "NEXT", nextIntent)

    }
    fun setNotification(currentConversationId: Int){
        val conversation = ConversationRepository.conversations[currentConversationId]
        val icon = BitmapFactory.decodeResource(context.resources, conversation.picture)

        val bundle = Bundle().apply {
            putInt("idConversation", currentConversationId)
        }

        val pendingIntent = NavDeepLinkBuilder(context)
            .setComponentName(MainActivity::class.java)
            .setGraph(R.navigation.my_nav)
            .setDestination(R.id.conversationFragment)
            .setArguments(bundle)
            .createPendingIntent()

        val upBuilder = builder
            .setContentTitle(conversation.dia.toString())
            .setContentText(conversation.tema)
            .setLargeIcon(icon)
            .setContentIntent(pendingIntent)
            .setStyle(androidx.media.app.NotificationCompat.MediaStyle())
            .setShowWhen(false)
            .setAutoCancel(false)
            .setSilent(true)
            .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
            .setPriority(NotificationCompat.PRIORITY_LOW)

        manager.notify(1, upBuilder.build())
    }
}

