package com.example.android.cactus.homeScreen.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.homeScreen.domain.model.Conversation
import com.example.android.cactus.homeScreen.presentation.holder.ConversationHolder

class ConversatioAdapter (
    private val list: ArrayList<Conversation>,
    private val action: (Int) -> Unit
): RecyclerView.Adapter<ConversationHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int)
            : ConversationHolder = ConversationHolder.create(parent, action)

    override fun onBindViewHolder(holder: ConversationHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}