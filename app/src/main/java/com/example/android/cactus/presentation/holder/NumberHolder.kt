package com.example.android.cactus.presentation.holder

import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.databinding.ItembuttomNumBinding
import com.example.android.cactus.domain.model.Number

class NumberHolder(private val binding: ItembuttomNumBinding,
                   private val action: (Number)-> Unit
) : RecyclerView.ViewHolder(binding.root){
    fun onBind(number: Number) {
        binding.run {
            buttonZero.text = number.num

            buttonZero.setOnClickListener { action(number) }
        }
    }
}