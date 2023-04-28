package com.example.android.cactus.presentation.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.android.cactus.databinding.ItemhandBinding
import com.example.android.cactus.domain.model.HandWriting

class HandWritingHolder(private val binding: ItemhandBinding,
                        private  val glide: RequestManager,
                        private  val action: (Int) -> Unit): RecyclerView.ViewHolder(binding.root) {

    private  var handItem: HandWriting? = null

    init{
        itemView.setOnClickListener{
            handItem?.id?.also(action)
        }
    }

    fun bind(item: HandWriting){
        handItem = item

        with(binding){
            tvWord.text = item.title

            glide.load(item.url).into(imageView2)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager,
            action: (Int)-> Unit
        ) = HandWritingHolder(
            ItemhandBinding.inflate(
                LayoutInflater
                    .from(parent.context),
                parent,
                false
            ),
            glide,
            action
        )
    }
}