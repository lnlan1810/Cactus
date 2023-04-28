package com.example.android.cactus.presentation.fragment

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentNumberInfoBinding
import com.example.android.cactus.domain.repository.NumberRepository

class NumberInfoFragment: Fragment(R.layout.fragment_number_info) {

    private var binding: FragmentNumberInfoBinding? = null
    private var mediaPlayer: MediaPlayer? = null
    private var number_id: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            number_id = it.getInt(ARG_NUMBER_ID)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNumberInfoBinding.bind(view)
        binding?.run {
            val number = number_id?.let { NumberRepository.getNumber(it) }
            if (number != null) {
                image.setImageResource(number.picture)
            }
            tvNum.text = number?.num
            tvNumtext.text = number?.text
            tvNumtr.text= number?.mean

            btSound.setOnClickListener {
                if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                    mediaPlayer!!.stop()
                }
                mediaPlayer = MediaPlayer().apply {
                    val soundUri = Uri.parse("android.resource://${requireContext().packageName}/${number?.audio}")
                    setDataSource(requireContext(), soundUri)
                    prepare()
                    start()
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    companion object {
        private const val ARG_NUMBER_ID = "number_id"

        fun newInstance(numberId: Int): NumberInfoFragment {
            val args = Bundle().apply {
                putInt(ARG_NUMBER_ID, numberId)
            }
            val fragment = NumberInfoFragment()
            fragment.arguments = args
            return fragment
        }
    }
}


/*
class NumberInfoFragment: Fragment(R.layout.fragment_number_info) {

    private var mediaPlayer: MediaPlayer? = null
    private var _binding: FragmentNumberInfoBinding? = null
    private val binding get() = _binding
    private var numID : Int = -1
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentNumberInfoBinding.bind(view)

        numID = arguments?.getString(NUMBER_INFO_FRAGMENT_TAG)?.toIntOrNull() ?: 0
        val number = NumberRepository.numbers[numID]

        binding?.run{
            image.setImageResource(number.picture)
            tvNum.text = number.num
            tvNumtext.text = number.text
            tvNumtr.text= number.mean

            btSound.setOnClickListener {
                // Kiểm tra trước tiên xem có đang có MediaPlayer đang phát không
                if (mediaPlayer != null && mediaPlayer!!.isPlaying) {
                    mediaPlayer!!.stop()
                }
                // Khởi tạo MediaPlayer mới và cài đặt source tương ứng với số được chọn
                mediaPlayer = MediaPlayer().apply {
                    val soundUri = Uri.parse("android.resource://${requireContext().packageName}/${number.audio}")
                    setDataSource(requireContext(), soundUri)
                    prepare()
                    start()
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        mediaPlayer?.release()
        mediaPlayer = null
    }

    companion object {

        const val NUMBER_INFO_FRAGMENT_TAG = "NUMBER_INFO_FRAGMENT_TAG"

        fun getInstance(message: String)
                = NumberInfoFragment().apply {
            arguments = Bundle().apply {
                putString(NUMBER_INFO_FRAGMENT_TAG,message)
            }
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}

 */