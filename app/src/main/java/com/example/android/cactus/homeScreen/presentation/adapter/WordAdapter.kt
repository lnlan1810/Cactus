package com.example.android.cactus.homeScreen.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.android.cactus.homeScreen.domain.model.Word
import com.example.android.cactus.homeScreen.presentation.holder.WordHolder

class WordAdapter (
    private val list: ArrayList<Word>,
    private  val glide: RequestManager,
    private val action: (Int) -> Unit
): RecyclerView.Adapter<WordHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int)
            : WordHolder = WordHolder.create(parent,glide, action)

    override fun onBindViewHolder(holder: WordHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}