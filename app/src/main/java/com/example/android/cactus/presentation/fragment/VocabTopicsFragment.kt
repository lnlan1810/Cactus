package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentVocabTopicsBinding

class VocabTopicsFragment : Fragment(R.layout.fragment_vocab_topics) {

    private var _binding: FragmentVocabTopicsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentVocabTopicsBinding.bind(view)

        binding.buttonback.setOnClickListener {
            activity?.onBackPressed()
        }
    }

}