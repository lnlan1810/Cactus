package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentPersonnalLessionBinding

class PersonnalLessionFragment : Fragment(R.layout.fragment_personnal_lession) {
    private var _binding: FragmentPersonnalLessionBinding? = null

    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPersonnalLessionBinding.bind(view)

        view.findViewById<Button>(R.id.buttonback).setOnClickListener {
            activity?.onBackPressed()
        }

    }
}