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
import com.example.android.cactus.databinding.FragmentVerbBinding
import com.example.android.cactus.homeScreen.SpaceItemDecorator
import com.example.android.cactus.homeScreen.domain.VerbRepository
import com.example.android.cactus.homeScreen.domain.WordRepository
import com.example.android.cactus.homeScreen.presentation.adapter.WordAdapter

class VerbFragment : Fragment(R.layout.fragment_verb) {
    private var _binding: FragmentVerbBinding? = null
    private val binding get() = _binding!!

    private var verbAdapter: WordAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentVerbBinding.bind(view)

        view.findViewById<Button>(R.id.buttonback).setOnClickListener {
            activity?.onBackPressed()
        }
        initAdapter()


    }

    private fun initAdapter() {
        verbAdapter = WordAdapter(
            VerbRepository.words,
            Glide.with(this)
        ) {
        }

        binding.rvWords.adapter = verbAdapter
        binding.rvWords.layoutManager = GridLayoutManager(requireContext(), 1)

    }
}