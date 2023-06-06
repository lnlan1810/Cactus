package com.example.android.cactus.presentation.adapter

import androidx.recyclerview.widget.ListAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.databinding.ItembuttomNumBinding
import com.example.android.cactus.domain.model.Number
import com.example.android.cactus.presentation.holder.NumberHolder


class NumberAdapter(
  //  private val list: List<Number>,
    private val action: (Number) -> Unit
) : ListAdapter<Number, NumberHolder>(NumberDiffCallback()) {
    /*override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NumberHolder(
        ItembuttomNumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ),
        action
    )*/

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumberHolder {
        val binding = ItembuttomNumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return NumberHolder(binding, action)
    }

    /*override fun onBindViewHolder(holder: NumberHolder, position: Int) {
        holder.onBind(list[position])
    }*/

    override fun onBindViewHolder(holder: NumberHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    //override fun getItemCount(): Int = list.size
    class NumberDiffCallback : DiffUtil.ItemCallback<Number>() {
        override fun areItemsTheSame(oldItem: Number, newItem: Number): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Number, newItem: Number): Boolean {
            return oldItem == newItem
        }
    }
}
