package com.example.android.cactus.grammarScreen.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentPastLessionBinding

class PastLessionFragment : Fragment(R.layout.fragment_past_lession) {

    private var _binding: FragmentPastLessionBinding? = null

    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPastLessionBinding.bind(view)

        view.findViewById<Button>(R.id.buttonback).setOnClickListener {
            activity?.onBackPressed()
        }

    }
}