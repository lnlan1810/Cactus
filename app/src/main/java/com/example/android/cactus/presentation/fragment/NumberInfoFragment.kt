package com.example.android.cactus.presentation.fragment

import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
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

            buttonback.setOnClickListener {
                findNavController().navigate(
                    R.id.action_mainNumberFragment_to_homeFragment2,
                )            }
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
