package com.example.android.cactus.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.databinding.CategoryListItemBinding
import com.example.android.cactus.domain.model.Category

class CategoryListAdapter(
    //private val categoryList: ArrayList<Category> = ArrayList(),
    val clickListener: ItemClickListener
) : ListAdapter<Category, CategoryListAdapter.CategoryViewHolder>(CategoryDiffCallback()) {

    interface ItemClickListener {
        fun onListItemClick(itemId: Long)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemBinding =
            CategoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(itemBinding)
    }

   // override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.bind(getItem(position))


    inner class CategoryViewHolder(private val itemBinding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(category: Category) {
            itemBinding.categoryListName.text = category.name
            itemBinding.categoryListLayout.setOnClickListener { clickListener.onListItemClick(category.id) }
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }
    }

    /*fun setData(list: List<Category>) {
        categoryList.clear()
        categoryList.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        categoryList.clear()
        notifyDataSetChanged()
    }*/

    fun setData(list: List<Category>) {
        submitList(list)
    }
}
