package com.example.android.cactus.presentation.fragment

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDayBinding.bind(view)

        with(binding){
            buttonback.setOnClickListener {
                activity?.onBackPressed()
            }

            cardView4.setOnClickListener {
                soundOn(WeekDay.MONDAY)
            }

            cardviewtues.setOnClickListener {
                soundOn(WeekDay.TUESDAY)
            }

            cardviewed.setOnClickListener {
                soundOn(WeekDay.WEDNESDAY)
            }

            cardwiewthu.setOnClickListener {
                soundOn(WeekDay.THURSDAY)
            }

            cardviewfri.setOnClickListener {
                soundOn(WeekDay.FRIDAY)
            }

        }
    }

    enum class WeekDay(val res: Int) {
        MONDAY(R.raw.mon),
        TUESDAY(R.raw.tues),
        WEDNESDAY(R.raw.wed),
        THURSDAY(R.raw.thur),
        FRIDAY(R.raw.fri),
        SUN(R.raw.sun)
    }

    fun soundOn(weekDay: WeekDay){
        val player = MediaPlayer.create(context, weekDay.res)
        player.start()
        player.setOnCompletionListener {
            player.release()
        }
    }

    fun onBackPressed() {
        getActivity()?.onBackPressed();
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

