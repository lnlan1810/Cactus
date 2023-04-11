package com.example.android.cactus.homeScreen.presentation.fragment

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentConversationBinding
import com.example.android.cactus.homeScreen.domain.model.Conversation
import com.example.android.cactus.homeScreen.domain.ConversationRepository
import com.example.android.cactus.homeScreen.presentation.service.ConversationService
import kotlinx.android.synthetic.main.fragment_conversation.*

class ConversationFragment : Fragment(R.layout.fragment_conversation) {

    private var _binding: FragmentConversationBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentConversationBinding.inflate(inflater, container, false)
        return binding.root
    }

    private var binder: ConversationService.ConversationBinder? = null
    private var conversationService : ConversationService? = null
    private lateinit var conversation: Conversation

    private val connection = object  : ServiceConnection{
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            binder =  service as? ConversationService.ConversationBinder
            conversationService = binder?.getService()
            connectConversation()


        }

        override fun onServiceDisconnected(name: ComponentName?) {
            conversationService = null
            binder = null
        }
    }

    private  fun connectConversation(){
        val idConversation = arguments?.getInt("idConversation")
        idConversation?.let{
            setData(idConversation)
            playConversation(idConversation)
        }
    }

    private fun playConversation(idConversation: Int){
        conversationService?.currentConversation(idConversation)
        with(binding){

            ibPrev.setOnClickListener {
                conversationService?.previousConversation()
                setData(conversationService?.currentPosition)
                conversationService?.play()
                ibPausePlay.setBackgroundResource(R.drawable.ic_baseline_pause_24)
            }
            ibNext.setOnClickListener {
                conversationService?.nextConversation()
                setData(conversationService?.currentPosition)
                conversationService?.play()
                ibPausePlay.setBackgroundResource(R.drawable.ic_baseline_pause_24)
            }
            ibPausePlay.setOnClickListener {
                if(conversationService?.isPlay()  == true){
                    conversationService?.pause()
                    ibPausePlay.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24)

                }
                else{
                    conversationService?.play()
                    ibPausePlay.setBackgroundResource(R.drawable.ic_baseline_pause_24)
                }

            }
        }
    }

    private fun setData(id: Int?){
        id?.let{
            conversation = ConversationRepository.conversations[id]
        }
        tv_tema.text = conversation.tema
        tv_text.text =conversation.text
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.buttonback).setOnClickListener {
            activity?.onBackPressed()
        }

        activity?.bindService(
            Intent(context, ConversationService::class.java),
            connection,
            Context.BIND_AUTO_CREATE
        )
    }
}