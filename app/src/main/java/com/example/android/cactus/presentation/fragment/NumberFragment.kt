package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentNumberBinding
import com.example.android.cactus.domain.model.Number
import com.example.android.cactus.domain.repository.NumberRepository
import com.example.android.cactus.presentation.adapter.NumberAdapter
import com.example.android.cactus.presentation.ui.SpaceItemDecorator
import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter

class NumberFragment : Fragment(R.layout.fragment_number) {

    private var binding: FragmentNumberBinding? = null
    private var adapter: NumberAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = FragmentNumberBinding.inflate(layoutInflater)
        binding?.run {
            val itemDecoration = SpaceItemDecorator(requireContext(), 16f)

            adapter = NumberAdapter() { number ->
                parentFragmentManager.beginTransaction()
                    .replace(R.id.left_fragment_container, NumberInfoFragment.newInstance(number.id))
                    .addToBackStack(null)
                    .commit()
            }
            rvNum.adapter = adapter
            val numberList: List<Number> = NumberRepository.numbers.toList()
            adapter!!.submitList(numberList)
            rvNum.addItemDecoration(itemDecoration)
            rvNum.adapter =  AlphaInAnimationAdapter(adapter!!).apply {
                setDuration(500)
                setFirstOnly(false)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        fun newInstance(number_id: Int): NumberFragment {
            val args = Bundle().apply {
                putInt(ARG_NUMBER_ID, number_id)
            }
            val fragment = NumberFragment()
            fragment.arguments = args
            return fragment
        }

        private const val ARG_NUMBER_ID = "number_id"
    }
}
