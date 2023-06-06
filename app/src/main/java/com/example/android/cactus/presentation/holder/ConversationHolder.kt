package com.example.android.cactus.presentation.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.databinding.ItemConversationBinding
import com.example.android.cactus.domain.model.Conversation

class ConversationHolder (
   private val binding: ItemConversationBinding,
   private val action: (Int) -> Unit
): RecyclerView.ViewHolder(binding.root){
    private var conversation: Conversation? = null

    init{
        itemView.setOnClickListener{
            conversation?.id?.also(action)
        }
    }

    fun bind(item: Conversation){
        conversation = item

        with(binding){
            tvDia.setText(item.dia)
            tvText.text = item.tema
            ivPicture.setImageResource(item.picture)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            action: (Int) -> Unit
        ) = ConversationHolder(
            ItemConversationBinding.inflate(
                LayoutInflater
                    .from(parent.context),
                parent,
                false
            ),
            action
        )

    }
}
