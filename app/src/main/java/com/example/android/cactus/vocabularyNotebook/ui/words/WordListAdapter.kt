package com.example.android.cactus.vocabularyNotebook.ui.words

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.cactus.databinding.WordListItemBinding
import com.example.android.cactus.vocabularyNotebook.model.Word

class WordListAdapter(
    private val wordList: ArrayList<Word> = ArrayList(),
    val clickListener: ItemClickListener
) : RecyclerView.Adapter<WordListAdapter.WordViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(position: Int)
        fun onListeningClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        val itemBinding =
            WordListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WordViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return wordList.size
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.bind(wordList[position])
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

    fun setData(list: List<Word>) {
        wordList.clear()
        wordList.addAll(list)
        notifyDataSetChanged()
    }
}