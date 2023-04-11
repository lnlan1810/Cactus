package com.example.android.cactus.vocabularyNotebook.ui.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.databinding.CategoryListItemBinding
import com.example.android.cactus.vocabularyNotebook.model.Category

class CategoryListAdapter(
    private val categoryList: ArrayList<Category> = ArrayList(),
    val clickListener: ItemClickListener
) : RecyclerView.Adapter<CategoryListAdapter.CategoryViewHolder>() {

    interface ItemClickListener {
        fun onListItemClick(itemId: Long)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemBinding =
            CategoryListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) =
        holder.bind(categoryList[position])


    inner class CategoryViewHolder(private val itemBinding: CategoryListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(category: Category) {
            itemBinding.categoryListName.text = category.name
            itemBinding.categoryListLayout.setOnClickListener { clickListener.onListItemClick(category.id) }
        }
    }

    fun setData(list: List<Category>) {
        categoryList.clear()
        categoryList.addAll(list)
        notifyDataSetChanged()
    }

    fun clear() {
        categoryList.clear()
        notifyDataSetChanged()
    }
}
