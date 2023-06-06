package com.example.android.cactus.presentation.holder

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestManager
import com.example.android.cactus.databinding.ItemWordBinding
import com.example.android.cactus.domain.model.CommonWord

class WordHolder (
    private val binding: ItemWordBinding,
    private  val glide: RequestManager,
    private val action: (Int)-> Unit
) : RecyclerView.ViewHolder(binding.root) {

    private var commonWord: CommonWord? = null

    init{
        itemView.setOnClickListener{
            commonWord?.id?.also(action)
        }
    }

    fun bind(item: CommonWord) {
        commonWord = item

        with(binding) {
            tvWord.text = item.vocabulary
            tvMean.setText(item.mean)
            ivPic.setImageResource(item.picture)
        }
    }

    companion object {
        fun create(
            parent: ViewGroup,
            glide: RequestManager,
            action: (Int) -> Unit
        ) = WordHolder(
            ItemWordBinding.inflate(
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
