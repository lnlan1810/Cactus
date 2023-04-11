package com.example.android.cactus.homeScreen.presentation.fragment

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentDayBinding

import kotlinx.android.synthetic.main.fragment_day.*


class DayFragment : Fragment(R.layout.fragment_day) {
    private var _binding: FragmentDayBinding? = null
    private  val binding get() = _binding!!
    var day =""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDayBinding.bind(view)

        view.findViewById<Button>(R.id.buttonback).setOnClickListener {
            activity?.onBackPressed()
        }

        with(binding){
            cardView4.setOnClickListener {
                day = "Понедельник"
                soundOn()
            }

            cardviewtues.setOnClickListener {
                day = "Вторник"
                soundOn()
            }

            cardviewed.setOnClickListener {
                day = "Среда"
                soundOn()
            }

            cardwiewthu.setOnClickListener {
                day = "Четверг"
                soundOn()
            }

            cardviewfri.setOnClickListener {
                day = "Пятница"
                soundOn()
            }

        }

    }

    fun soundOn(){
        when (day) {
            "Понедельник" -> {
                val player = MediaPlayer.create(context, R.raw.mon)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
        }

        when (day) {
            "Вторник" -> {
                val player = MediaPlayer.create(context, R.raw.tues)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
        }

        when (day) {
            "Среда" -> {
                val player = MediaPlayer.create(context, R.raw.wed)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
        }

        when (day) {
            "Четверг" -> {
                val player = MediaPlayer.create(context, R.raw.thur)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
        }

        when (day) {
            "Пятница" -> {
                val player = MediaPlayer.create(context, R.raw.fri)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
        }

        when (day) {
            "Суббота" -> {
                val player = MediaPlayer.create(context, R.raw.sat)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
        }

        when (day) {
            "Воскресенье" -> {
                val player = MediaPlayer.create(context, R.raw.sun)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
        }
    }

    fun onBackPressed() {
        // Call the parent onBackPressed() method to handle the default behavior
        getActivity()?.onBackPressed();

        // Navigate back to the previous fragment using the FragmentManager
        fragmentManager?.popBackStack()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {

        private const val DAY_FRAGMENT_TAG = "DAY_FRAGMENT_TAG"

        fun getInstance(message: String)
                = HandwritingFragment().apply {
            arguments = Bundle().apply {
                putString(DAY_FRAGMENT_TAG,message)
            }
        }
    }

}
