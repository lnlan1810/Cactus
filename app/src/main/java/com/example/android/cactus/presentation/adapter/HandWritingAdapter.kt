package com.example.android.cactus.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.example.android.cactus.domain.model.HandWriting
import com.example.android.cactus.presentation.holder.HandWritingHolder

class HandWritingAdapter(private val list: ArrayList<HandWriting>,
                         private  val glide: RequestManager,
                         private val action: (Int) -> Unit
) : ListAdapter<HandWriting, HandWritingHolder>(HandWritingDiffCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : HandWritingHolder = HandWritingHolder.create(parent, glide, action)

    override fun onBindViewHolder(holder: HandWritingHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class HandWritingDiffCallback : DiffUtil.ItemCallback<HandWriting>() {
        override fun areItemsTheSame(oldItem: HandWriting, newItem: HandWriting): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: HandWriting, newItem: HandWriting): Boolean {
            return oldItem == newItem
        }
    }
}