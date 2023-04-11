package com.example.android.cactus.homeScreen.presentation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.android.cactus.homeScreen.domain.model.HandWriting
import com.example.android.cactus.homeScreen.presentation.holder.HandWritingHolder

class HandWritingAdapter(private val list: ArrayList<HandWriting>,
                         private  val glide: RequestManager,
                         private val action: (Int) -> Unit
) : RecyclerView.Adapter<HandWritingHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
    : HandWritingHolder = HandWritingHolder.create(parent, glide, action)

    override fun onBindViewHolder(holder: HandWritingHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}