package com.example.android.cactus.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentHandwritingBinding
import com.example.android.cactus.domain.repository.HandwritingResponsitory
import com.example.android.cactus.presentation.adapter.HandWritingAdapter

class HandwritingFragment : Fragment(R.layout.fragment_handwriting) {

    private var _binding: FragmentHandwritingBinding? = null
    private  val binding get() = _binding!!
    private var adapter: HandWritingAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHandwritingBinding.bind(view)

        with(binding) {
            buttonback.setOnClickListener {
                activity?.onBackPressed()
            }
        }
        initAdapter()
    }

    /*private fun initAdapter() {
        adapter = HandWritingAdapter(
            HandwritingResponsitory.handWriting,
            Glide.with(this)
        ) {

        }
        binding.rvHandwriting.adapter = adapter
        binding.rvHandwriting.layoutManager = GridLayoutManager(requireContext(), 1)
    }*/

    private fun initAdapter() {
        adapter = HandWritingAdapter(Glide.with(this)) {
            // Xử lý sự kiện
        }
        binding.rvHandwriting.adapter = adapter
        binding.rvHandwriting.layoutManager = GridLayoutManager(requireContext(), 1)

        // Tạo mới danh sách `List<HandWriting>`
        val handwritingList = HandwritingResponsitory.handWriting.toList()

        // Khởi tạo adapter với danh sách mới
        adapter!!.submitList(handwritingList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val MAIN_FRAGMENT_TAG = "HANDWRITING_FRAGMENT_TAG"

        fun getInstance(message: String)
                = HandwritingFragment().apply {
            arguments = Bundle().apply {
                putString(MAIN_FRAGMENT_TAG,message)

            }
        }
    }

}