package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentDayBinding
import com.example.android.cactus.databinding.FragmentHomeBinding
import com.example.android.cactus.databinding.FragmentMainNumberBinding
import com.example.android.cactus.domain.repository.NumberRepository

class MainNumberFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_number, container, false)
    }
    private var _binding: FragmentMainNumberBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentMainNumberBinding.bind(view)


        val numberInfoFragment = NumberInfoFragment.newInstance(NumberRepository.numbers[0].id)
        childFragmentManager.beginTransaction()
            .replace(R.id.left_fragment_container, numberInfoFragment)
            .commit()

        val numberFragment = NumberFragment.newInstance(NumberRepository.numbers[0].id)
        childFragmentManager.beginTransaction()
            .replace(R.id.right_fragment_container, numberFragment)
            .commit()

    }
}