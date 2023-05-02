package com.example.android.cactus.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.RequestManager
import com.example.android.cactus.domain.model.CommonWord
import com.example.android.cactus.presentation.holder.WordHolder

class WordAdapter (
   // private val list: ArrayList<CommonWord>,
    private  val glide: RequestManager,
    private val action: (Int) -> Unit
): ListAdapter<CommonWord, WordHolder>(WoDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int)
            : WordHolder = WordHolder.create(parent,glide, action)

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        holder.bind(getItem(position))
    }
    // override fun getItemCount(): Int = list.size

    class WoDiffCallback : DiffUtil.ItemCallback<CommonWord>() {
        override fun areItemsTheSame(oldItem: CommonWord, newItem: CommonWord): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: CommonWord, newItem: CommonWord): Boolean {
            return oldItem == newItem
        }
    }
}