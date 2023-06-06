package com.example.android.cactus.presentation.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.databinding.WordListItemBinding
import com.example.android.cactus.domain.model.Category
import com.example.android.cactus.domain.model.Word

class WordListAdapter(
 //   private val wordList: ArrayList<Word> = ArrayList(),
    val clickListener: ItemClickListener
) : ListAdapter< Word, WordListAdapter.WordViewHolder>(WordDiffCallback()) {

    interface ItemClickListener {
        fun onItemClick(position: Int)
        fun onListeningClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemBinding =
            WordListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(itemBinding)
    }

   /* override fun getItemCount(): Int {
        return wordList.size
    }*/

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
      //  holder.bind(wordList[position])
        holder.bind(getItem(position))
    }

    inner class WordViewHolder(private val itemBinding: WordListItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        init {
            itemView.setOnClickListener { clickListener.onItemClick(adapterPosition) }
            itemBinding.wordListListenig.setOnClickListener { clickListener.onListeningClick(adapterPosition) }
        }

        fun bind(word: Word) {
            itemBinding.wordListName.text = word.name
            itemBinding.wordListTrans.text = word.translation
        }
    }

    class WordDiffCallback : DiffUtil.ItemCallback<Word>() {
        override fun areItemsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem.id == newItem.id
        }
        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Word, newItem: Word): Boolean {
            return oldItem == newItem
        }
    }

   /* fun setData(list: List<Word>) {
        wordList.clear()
        wordList.addAll(list)
        notifyDataSetChanged()
    }*/

    fun setData(list: List<Word>) {
        submitList(list)
    }
}