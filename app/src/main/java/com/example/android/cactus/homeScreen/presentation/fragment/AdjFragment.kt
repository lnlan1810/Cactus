package com.example.android.cactus.homeScreen.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentAdjBinding
import com.example.android.cactus.homeScreen.domain.AdjRepository
import com.example.android.cactus.homeScreen.presentation.adapter.WordAdapter

class AdjFragment : Fragment(R.layout.fragment_adj) {
    private var _binding: FragmentAdjBinding? = null
    private val binding get() = _binding!!

    private var adjAdapter: WordAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentAdjBinding.bind(view)

        view.findViewById<Button>(R.id.buttonback).setOnClickListener {
            activity?.onBackPressed()
        }
        initAdapter()
    }

    private fun initAdapter() {
        adjAdapter = WordAdapter(
            AdjRepository.words,
            Glide.with(this)
        ) {
        }

        binding.rvWords.adapter = adjAdapter
        binding.rvWords.layoutManager = GridLayoutManager(requireContext(), 1)

    }
}