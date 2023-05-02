package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentAdjBinding
import com.example.android.cactus.domain.repository.AdjRepository
import com.example.android.cactus.domain.repository.WordRepository
import com.example.android.cactus.presentation.adapter.WordAdapter

class AdjFragment : Fragment(R.layout.fragment_adj) {
    private var _binding: FragmentAdjBinding? = null
    private val binding get() = _binding!!

    private var adjAdapter: WordAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAdjBinding.bind(view)

        with(binding) {
            buttonback.setOnClickListener {
                activity?.onBackPressed()
            }
        }
        initAdapter()
    }

    private fun initAdapter() {
        /*adjAdapter = WordAdapter(
            AdjRepository.commonWords,
            Glide.with(this)
        ) {
        }*/
        adjAdapter = WordAdapter(Glide.with(this)) {
        }

        binding.rvWords.adapter = adjAdapter
        binding.rvWords.layoutManager = GridLayoutManager(requireContext(), 1)

        // Tạo mới danh sách `List<HandWriting>`
        val wordList = AdjRepository.commonWords.toList()

        // Khởi tạo adapter với danh sách mới
        adjAdapter!!.submitList(wordList)
    }
}