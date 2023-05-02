package com.example.android.cactus.presentation.service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import com.example.android.cactus.domain.model.Conversation
import com.example.android.cactus.domain.repository.ConversationRepository

class ConversationService : Service() {
    private var mediaPlayer: MediaPlayer = MediaPlayer()
    var currentPosition: Int = 0
    private var conversationBinder: ConversationBinder = ConversationBinder()
    private var conversations: List<Conversation> = ConversationRepository.conversations
    private var notificationService: NotificationService? = null
    inner class ConversationBinder: Binder(){
        //give service
        fun getService(): ConversationService = this@ConversationService
    }

    override fun onCreate(){
        super.onCreate()
        notificationService = NotificationService(this)
        notificationService!!.setNotification(currentPosition)
    }

    override fun onBind(intent: Intent): IBinder = conversationBinder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when(intent?.action){
            "PREVIOUS" -> {previousConversation()}
            "PAUSE" -> {if (mediaPlayer.isPlaying)
                mediaPlayer.pause()
                else mediaPlayer.start()
            }
            "NEXT" -> {nextConversation()}
        }
        return super.onStartCommand(intent, flags, startId)
    }
    override fun onDestroy(){
        super.onDestroy()
        mediaPlayer.release()
    }

    fun previousConversation(){
        if(currentPosition == 0){
            currentPosition = conversations.size
        }

        else currentPosition --
        currentConversation(currentPosition)
    }

    fun nextConversation(){
        if(currentPosition == conversations.size -1){
            currentPosition = 0
        }
        else currentPosition ++
        currentConversation(currentPosition)
    }

    fun pause(){
        mediaPlayer.pause()
    }

    fun play(){
        mediaPlayer.start()
    }

    fun isPlay() = mediaPlayer.isPlaying

    fun currentConversation(selectedConversationId : Int){
        if (mediaPlayer.isPlaying) mediaPlayer.stop()
        mediaPlayer = MediaPlayer.create(applicationContext, conversations[selectedConversationId].audio)
        currentPosition = selectedConversationId
        mediaPlayer.start()
        notificationService?.setNotification(selectedConversationId)
    }

}
