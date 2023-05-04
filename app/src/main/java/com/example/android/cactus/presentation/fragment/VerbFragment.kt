package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentVerbBinding
import com.example.android.cactus.domain.repository.VerbRepository
import com.example.android.cactus.domain.repository.WordRepository
import com.example.android.cactus.presentation.adapter.WordAdapter

class VerbFragment : Fragment(R.layout.fragment_verb) {
    private var _binding: FragmentVerbBinding? = null
    private val binding get() = _binding!!
    private var verbAdapter: WordAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentVerbBinding.bind(view)
        binding.buttonback.setOnClickListener {
            activity?.onBackPressed()
        }
        initAdapter()
    }

    private fun initAdapter() {
        verbAdapter = WordAdapter(Glide.with(this)) {
        }

        binding.rvWords.adapter = verbAdapter
        binding.rvWords.layoutManager = GridLayoutManager(requireContext(), 1)
        val wordList = VerbRepository.words.toList()

        verbAdapter!!.submitList(wordList)
    }
}