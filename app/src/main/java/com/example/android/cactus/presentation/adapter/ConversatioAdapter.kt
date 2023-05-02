package com.example.android.cactus.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.android.cactus.domain.model.Conversation
import com.example.android.cactus.presentation.holder.ConversationHolder

class ConversatioAdapter (
  //  private val list: ArrayList<Conversation>,
    private val action: (Int) -> Unit
): ListAdapter<Conversation, ConversationHolder>(ConversationDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int)
            : ConversationHolder = ConversationHolder.create(parent, action)

    override fun onBindViewHolder(holder: ConversationHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ConversationDiffCallback : DiffUtil.ItemCallback<Conversation>() {
        override fun areItemsTheSame(oldItem: Conversation, newItem: Conversation): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Conversation, newItem: Conversation): Boolean {
            return oldItem == newItem
        }
    }
}