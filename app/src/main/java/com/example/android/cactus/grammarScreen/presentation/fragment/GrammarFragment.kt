package com.example.android.cactus.grammarScreen.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentGrammarBinding

class GrammarFragment : Fragment(R.layout.fragment_grammar) {

    private var _binding: FragmentGrammarBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGrammarBinding.bind(view)

        with(binding){
            ivPresent.setOnClickListener{
                val bundle = Bundle()
                findNavController().navigate(R.id.action_grammarFragment_to_presentLessionFragment2, bundle)
            }

            ivPerson.setOnClickListener{
                val bundle = Bundle()
                findNavController().navigate(R.id.action_grammarFragment_to_personnalLessionFragment2, bundle)
            }

            ivFuture.setOnClickListener{
                val bundle = Bundle()
                findNavController().navigate(R.id.action_grammarFragment_to_futureLessionFragment2, bundle)
            }

            ivPast.setOnClickListener{
                val bundle = Bundle()
                findNavController().navigate(R.id.action_grammarFragment_to_pastLessionFragment2, bundle)
            }


        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}