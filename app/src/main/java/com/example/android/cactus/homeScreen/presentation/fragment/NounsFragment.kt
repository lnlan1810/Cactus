package com.example.android.cactus.homeScreen.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentNounsBinding
import com.example.android.cactus.homeScreen.SpaceItemDecorator
import com.example.android.cactus.homeScreen.domain.WordRepository
import com.example.android.cactus.homeScreen.presentation.adapter.WordAdapter


class NounsFragment : Fragment(R.layout.fragment_nouns) {
    private var _binding: FragmentNounsBinding? = null
    private val binding get() = _binding!!

    private var musicAdapter: WordAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNounsBinding.bind(view)

        view.findViewById<Button>(R.id.buttonback).setOnClickListener {
            activity?.onBackPressed()
        }
        initAdapter()


    }

    private fun initAdapter() {
        musicAdapter = WordAdapter(
            WordRepository.words,
            Glide.with(this)
        ) {
        }

        binding.rvWords.adapter = musicAdapter
        binding.rvWords.layoutManager = GridLayoutManager(requireContext(), 1)

    }
}