package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentNounsBinding
import com.example.android.cactus.domain.repository.HandwritingResponsitory
import com.example.android.cactus.domain.repository.WordRepository
import com.example.android.cactus.presentation.adapter.HandWritingAdapter
import com.example.android.cactus.presentation.adapter.WordAdapter


class NounsFragment : Fragment(R.layout.fragment_nouns) {

    private var _binding: FragmentNounsBinding? = null
    private val binding get() = _binding!!
    private var wordAdapter: WordAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNounsBinding.bind(view)

        binding.buttonback.setOnClickListener {
            activity?.onBackPressed()
        }
        initAdapter()
    }

    private fun initAdapter() {
        wordAdapter = WordAdapter(Glide.with(this)) {
        }
        binding.rvWords.adapter = wordAdapter
        binding.rvWords.layoutManager = GridLayoutManager(requireContext(), 1)

        val wordList = WordRepository.words.toList()

        wordAdapter!!.submitList(wordList)
    }
}