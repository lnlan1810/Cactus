package com.example.android.cactus.homeScreen.presentation.fragment

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.android.cactus.R
import com.example.android.cactus.databinding.FragmentNumberBinding
import kotlinx.android.synthetic.main.fragment_number.*

class NumberFragment : Fragment(R.layout.fragment_number) {

    private var _binding: FragmentNumberBinding? = null
    private  val binding get() = _binding!!

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentNumberBinding.bind(view)

        view.findViewById<Button>(R.id.buttonback).setOnClickListener {
            activity?.onBackPressed()
        }

        with(binding){
            button_zero.setOnClickListener {
                tvNum.text = "0"
                tvNumtext.text = "нуль"
                tvNumtr.text = "zero"
                gambar.setImageResource(R.mipmap.zero)
                soundOn()

                buttonZero.setBackgroundResource(R.drawable.buttonorange)
                buttonZero.setTextColor(resources.getColor(R.color.colorPrimaryDark))

                button_one.setBackgroundResource(R.drawable.buttonnum)
                button_one.setTextColor(resources.getColor(R.color.white))

                button_two.setBackgroundResource(R.drawable.buttonnum)
                button_two.setTextColor(resources.getColor(R.color.white))

                button_three.setBackgroundResource(R.drawable.buttonnum)
                button_three.setTextColor(resources.getColor(R.color.white))

                button_four.setBackgroundResource(R.drawable.buttonnum)
                button_four.setTextColor(resources.getColor(R.color.white))

                button_five.setBackgroundResource(R.drawable.buttonnum)
                button_five.setTextColor(resources.getColor(R.color.white))

                button_six.setBackgroundResource(R.drawable.buttonnum)
                button_six.setTextColor(resources.getColor(R.color.white))

                button_seven.setBackgroundResource(R.drawable.buttonnum)
                button_seven.setTextColor(resources.getColor(R.color.white))

                button_eight.setBackgroundResource(R.drawable.buttonnum)
                button_eight.setTextColor(resources.getColor(R.color.white))

                button_nine.setBackgroundResource(R.drawable.buttonnum)
                button_nine.setTextColor(resources.getColor(R.color.white))

                button_ten.setBackgroundResource(R.drawable.buttonnum)
                button_ten.setTextColor(resources.getColor(R.color.white))

                button_eleven.setBackgroundResource(R.drawable.buttonnum)
                button_eleven.setTextColor(resources.getColor(R.color.white))

                button_twelve.setBackgroundResource(R.drawable.buttonnum)
                button_twelve.setTextColor(resources.getColor(R.color.white))

                button_13.setBackgroundResource(R.drawable.buttonnum)
                button_13.setTextColor(resources.getColor(R.color.white))

                button_14.setBackgroundResource(R.drawable.buttonnum)
                button_14.setTextColor(resources.getColor(R.color.white))

                button_15.setBackgroundResource(R.drawable.buttonnum)
                button_15.setTextColor(resources.getColor(R.color.white))

                button_16.setBackgroundResource(R.drawable.buttonnum)
                button_16.setTextColor(resources.getColor(R.color.white))

                button_17.setBackgroundResource(R.drawable.buttonnum)
                button_17.setTextColor(resources.getColor(R.color.white))

                button_18.setBackgroundResource(R.drawable.buttonnum)
                button_18.setTextColor(resources.getColor(R.color.white))

                button_19.setBackgroundResource(R.drawable.buttonnum)
                button_19.setTextColor(resources.getColor(R.color.white))

                button_20.setBackgroundResource(R.drawable.buttonnum)
                button_20.setTextColor(resources.getColor(R.color.white))

                button_30.setBackgroundResource(R.drawable.buttonnum)
                button_30.setTextColor(resources.getColor(R.color.white))

                button_40.setBackgroundResource(R.drawable.buttonnum)
                button_40.setTextColor(resources.getColor(R.color.white))

                button_50.setBackgroundResource(R.drawable.buttonnum)
                button_50.setTextColor(resources.getColor(R.color.white))

                button_60.setBackgroundResource(R.drawable.buttonnum)
                button_60.setTextColor(resources.getColor(R.color.white))

                button_70.setBackgroundResource(R.drawable.buttonnum)
                button_70.setTextColor(resources.getColor(R.color.white))

                button_80.setBackgroundResource(R.drawable.buttonnum)
                button_80.setTextColor(resources.getColor(R.color.white))
            }

            button_one.setOnClickListener {
                tvNum.text = "1"
                tvNumtext.text = "один"
                tvNumtr.text = "one"
                gambar.setImageResource(R.mipmap.one)
                soundOn()

                buttonZero.setBackgroundResource(R.drawable.buttonnum)
                buttonZero.setTextColor(resources.getColor(R.color.white))

                button_one.setBackgroundResource(R.drawable.buttonorange)
                button_one.setTextColor(resources.getColor(R.color.colorPrimaryDark))

                button_two.setBackgroundResource(R.drawable.buttonnum)
                button_two.setTextColor(resources.getColor(R.color.white))

                button_three.setBackgroundResource(R.drawable.buttonnum)
                button_three.setTextColor(resources.getColor(R.color.white))

                button_four.setBackgroundResource(R.drawable.buttonnum)
                button_four.setTextColor(resources.getColor(R.color.white))

                button_five.setBackgroundResource(R.drawable.buttonnum)
                button_five.setTextColor(resources.getColor(R.color.white))

                button_six.setBackgroundResource(R.drawable.buttonnum)
                button_six.setTextColor(resources.getColor(R.color.white))

                button_seven.setBackgroundResource(R.drawable.buttonnum)
                button_seven.setTextColor(resources.getColor(R.color.white))

                button_eight.setBackgroundResource(R.drawable.buttonnum)
                button_eight.setTextColor(resources.getColor(R.color.white))

                button_nine.setBackgroundResource(R.drawable.buttonnum)
                button_nine.setTextColor(resources.getColor(R.color.white))

                button_ten.setBackgroundResource(R.drawable.buttonnum)
                button_ten.setTextColor(resources.getColor(R.color.white))

                button_eleven.setBackgroundResource(R.drawable.buttonnum)
                button_eleven.setTextColor(resources.getColor(R.color.white))

                button_twelve.setBackgroundResource(R.drawable.buttonnum)
                button_twelve.setTextColor(resources.getColor(R.color.white))

                button_13.setBackgroundResource(R.drawable.buttonnum)
                button_13.setTextColor(resources.getColor(R.color.white))

                button_14.setBackgroundResource(R.drawable.buttonnum)
                button_14.setTextColor(resources.getColor(R.color.white))

                button_15.setBackgroundResource(R.drawable.buttonnum)
                button_15.setTextColor(resources.getColor(R.color.white))

                button_16.setBackgroundResource(R.drawable.buttonnum)
                button_16.setTextColor(resources.getColor(R.color.white))

                button_17.setBackgroundResource(R.drawable.buttonnum)
                button_17.setTextColor(resources.getColor(R.color.white))

                button_18.setBackgroundResource(R.drawable.buttonnum)
                button_18.setTextColor(resources.getColor(R.color.white))

                button_19.setBackgroundResource(R.drawable.buttonnum)
                button_19.setTextColor(resources.getColor(R.color.white))

                button_20.setBackgroundResource(R.drawable.buttonnum)
                button_20.setTextColor(resources.getColor(R.color.white))

                button_30.setBackgroundResource(R.drawable.buttonnum)
                button_30.setTextColor(resources.getColor(R.color.white))

                button_40.setBackgroundResource(R.drawable.buttonnum)
                button_40.setTextColor(resources.getColor(R.color.white))

                button_50.setBackgroundResource(R.drawable.buttonnum)
                button_50.setTextColor(resources.getColor(R.color.white))

                button_60.setBackgroundResource(R.drawable.buttonnum)
                button_60.setTextColor(resources.getColor(R.color.white))

                button_70.setBackgroundResource(R.drawable.buttonnum)
                button_70.setTextColor(resources.getColor(R.color.white))

                button_80.setBackgroundResource(R.drawable.buttonnum)
                button_80.setTextColor(resources.getColor(R.color.white))
            }

            button_two.setOnClickListener {
                tvNum.text = "2"
                tvNumtext.text = "два"
                tvNumtr.text = "two"
                gambar.setImageResource(R.mipmap.two)
                soundOn()

                buttonZero.setBackgroundResource(R.drawable.buttonnum)
                buttonZero.setTextColor(resources.getColor(R.color.white))

                button_one.setBackgroundResource(R.drawable.buttonnum)
                button_one.setTextColor(resources.getColor(R.color.white))

                button_two.setBackgroundResource(R.drawable.buttonorange)
                button_two.setTextColor(resources.getColor(R.color.colorPrimaryDark))

                button_three.setBackgroundResource(R.drawable.buttonnum)
                button_three.setTextColor(resources.getColor(R.color.white))

                button_four.setBackgroundResource(R.drawable.buttonnum)
                button_four.setTextColor(resources.getColor(R.color.white))

                button_five.setBackgroundResource(R.drawable.buttonnum)
                button_five.setTextColor(resources.getColor(R.color.white))

                button_six.setBackgroundResource(R.drawable.buttonnum)
                button_six.setTextColor(resources.getColor(R.color.white))

                button_seven.setBackgroundResource(R.drawable.buttonnum)
                button_seven.setTextColor(resources.getColor(R.color.white))

                button_eight.setBackgroundResource(R.drawable.buttonnum)
                button_eight.setTextColor(resources.getColor(R.color.white))

                button_nine.setBackgroundResource(R.drawable.buttonnum)
                button_nine.setTextColor(resources.getColor(R.color.white))

                button_ten.setBackgroundResource(R.drawable.buttonnum)
                button_ten.setTextColor(resources.getColor(R.color.white))

                button_eleven.setBackgroundResource(R.drawable.buttonnum)
                button_eleven.setTextColor(resources.getColor(R.color.white))

                button_twelve.setBackgroundResource(R.drawable.buttonnum)
                button_twelve.setTextColor(resources.getColor(R.color.white))

                button_13.setBackgroundResource(R.drawable.buttonnum)
                button_13.setTextColor(resources.getColor(R.color.white))

                button_14.setBackgroundResource(R.drawable.buttonnum)
                button_14.setTextColor(resources.getColor(R.color.white))

                button_15.setBackgroundResource(R.drawable.buttonnum)
                button_15.setTextColor(resources.getColor(R.color.white))

                button_16.setBackgroundResource(R.drawable.buttonnum)
                button_16.setTextColor(resources.getColor(R.color.white))

                button_17.setBackgroundResource(R.drawable.buttonnum)
                button_17.setTextColor(resources.getColor(R.color.white))

                button_18.setBackgroundResource(R.drawable.buttonnum)
                button_18.setTextColor(resources.getColor(R.color.white))

                button_19.setBackgroundResource(R.drawable.buttonnum)
                button_19.setTextColor(resources.getColor(R.color.white))

                button_20.setBackgroundResource(R.drawable.buttonnum)
                button_20.setTextColor(resources.getColor(R.color.white))

                button_30.setBackgroundResource(R.drawable.buttonnum)
                button_30.setTextColor(resources.getColor(R.color.white))

                button_40.setBackgroundResource(R.drawable.buttonnum)
                button_40.setTextColor(resources.getColor(R.color.white))

                button_50.setBackgroundResource(R.drawable.buttonnum)
                button_50.setTextColor(resources.getColor(R.color.white))

                button_60.setBackgroundResource(R.drawable.buttonnum)
                button_60.setTextColor(resources.getColor(R.color.white))

                button_70.setBackgroundResource(R.drawable.buttonnum)
                button_70.setTextColor(resources.getColor(R.color.white))

                button_80.setBackgroundResource(R.drawable.buttonnum)
                button_80.setTextColor(resources.getColor(R.color.white))
            }

            button_three.setOnClickListener {
                tvNum.text = "3"
                tvNumtext.text = "три"
                tvNumtr.text = "three"
                gambar.setImageResource(R.mipmap.three)
                soundOn()

                buttonZero.setBackgroundResource(R.drawable.buttonnum)
                buttonZero.setTextColor(resources.getColor(R.color.white))

                button_one.setBackgroundResource(R.drawable.buttonnum)
                button_one.setTextColor(resources.getColor(R.color.white))

                button_two.setBackgroundResource(R.drawable.buttonnum)
                button_two.setTextColor(resources.getColor(R.color.white))

                button_three.setBackgroundResource(R.drawable.buttonorange)
                button_three.setTextColor(resources.getColor(R.color.colorPrimaryDark))

                button_four.setBackgroundResource(R.drawable.buttonnum)
                button_four.setTextColor(resources.getColor(R.color.white))

                button_five.setBackgroundResource(R.drawable.buttonnum)
                button_five.setTextColor(resources.getColor(R.color.white))

                button_six.setBackgroundResource(R.drawable.buttonnum)
                button_six.setTextColor(resources.getColor(R.color.white))

                button_seven.setBackgroundResource(R.drawable.buttonnum)
                button_seven.setTextColor(resources.getColor(R.color.white))

                button_eight.setBackgroundResource(R.drawable.buttonnum)
                button_eight.setTextColor(resources.getColor(R.color.white))

                button_nine.setBackgroundResource(R.drawable.buttonnum)
                button_nine.setTextColor(resources.getColor(R.color.white))

                button_ten.setBackgroundResource(R.drawable.buttonnum)
                button_ten.setTextColor(resources.getColor(R.color.white))

                button_eleven.setBackgroundResource(R.drawable.buttonnum)
                button_eleven.setTextColor(resources.getColor(R.color.white))

                button_twelve.setBackgroundResource(R.drawable.buttonnum)
                button_twelve.setTextColor(resources.getColor(R.color.white))

                button_13.setBackgroundResource(R.drawable.buttonnum)
                button_13.setTextColor(resources.getColor(R.color.white))

                button_14.setBackgroundResource(R.drawable.buttonnum)
                button_14.setTextColor(resources.getColor(R.color.white))

                button_15.setBackgroundResource(R.drawable.buttonnum)
                button_15.setTextColor(resources.getColor(R.color.white))

                button_16.setBackgroundResource(R.drawable.buttonnum)
                button_16.setTextColor(resources.getColor(R.color.white))

                button_17.setBackgroundResource(R.drawable.buttonnum)
                button_17.setTextColor(resources.getColor(R.color.white))

                button_18.setBackgroundResource(R.drawable.buttonnum)
                button_18.setTextColor(resources.getColor(R.color.white))

                button_19.setBackgroundResource(R.drawable.buttonnum)
                button_19.setTextColor(resources.getColor(R.color.white))

                button_20.setBackgroundResource(R.drawable.buttonnum)
                button_20.setTextColor(resources.getColor(R.color.white))

                button_30.setBackgroundResource(R.drawable.buttonnum)
                button_30.setTextColor(resources.getColor(R.color.white))

                button_40.setBackgroundResource(R.drawable.buttonnum)
                button_40.setTextColor(resources.getColor(R.color.white))

                button_50.setBackgroundResource(R.drawable.buttonnum)
                button_50.setTextColor(resources.getColor(R.color.white))

                button_60.setBackgroundResource(R.drawable.buttonnum)
                button_60.setTextColor(resources.getColor(R.color.white))

                button_70.setBackgroundResource(R.drawable.buttonnum)
                button_70.setTextColor(resources.getColor(R.color.white))

                button_80.setBackgroundResource(R.drawable.buttonnum)
                button_80.setTextColor(resources.getColor(R.color.white))
            }


            button_four.setOnClickListener {
                tvNum.text = "4"
                tvNumtext.text = "четыре"
                tvNumtr.text = "four"
                gambar.setImageResource(R.mipmap.four)
                soundOn()

                buttonZero.setBackgroundResource(R.drawable.buttonnum)
                buttonZero.setTextColor(resources.getColor(R.color.white))

                button_one.setBackgroundResource(R.drawable.buttonnum)
                button_one.setTextColor(resources.getColor(R.color.white))

                button_two.setBackgroundResource(R.drawable.buttonnum)
                button_two.setTextColor(resources.getColor(R.color.white))

                button_three.setBackgroundResource(R.drawable.buttonnum)
                button_three.setTextColor(resources.getColor(R.color.white))

                button_four.setBackgroundResource(R.drawable.buttonorange)
                button_four.setTextColor(resources.getColor(R.color.colorPrimaryDark))

                button_five.setBackgroundResource(R.drawable.buttonnum)
                button_five.setTextColor(resources.getColor(R.color.white))

                button_six.setBackgroundResource(R.drawable.buttonnum)
                button_six.setTextColor(resources.getColor(R.color.white))

                button_seven.setBackgroundResource(R.drawable.buttonnum)
                button_seven.setTextColor(resources.getColor(R.color.white))

                button_eight.setBackgroundResource(R.drawable.buttonnum)
                button_eight.setTextColor(resources.getColor(R.color.white))

                button_nine.setBackgroundResource(R.drawable.buttonnum)
                button_nine.setTextColor(resources.getColor(R.color.white))

                button_ten.setBackgroundResource(R.drawable.buttonnum)
                button_ten.setTextColor(resources.getColor(R.color.white))

                button_eleven.setBackgroundResource(R.drawable.buttonnum)
                button_eleven.setTextColor(resources.getColor(R.color.white))

                button_twelve.setBackgroundResource(R.drawable.buttonnum)
                button_twelve.setTextColor(resources.getColor(R.color.white))

                button_13.setBackgroundResource(R.drawable.buttonnum)
                button_13.setTextColor(resources.getColor(R.color.white))

                button_14.setBackgroundResource(R.drawable.buttonnum)
                button_14.setTextColor(resources.getColor(R.color.white))

                button_15.setBackgroundResource(R.drawable.buttonnum)
                button_15.setTextColor(resources.getColor(R.color.white))

                button_16.setBackgroundResource(R.drawable.buttonnum)
                button_16.setTextColor(resources.getColor(R.color.white))

                button_17.setBackgroundResource(R.drawable.buttonnum)
                button_17.setTextColor(resources.getColor(R.color.white))

                button_18.setBackgroundResource(R.drawable.buttonnum)
                button_18.setTextColor(resources.getColor(R.color.white))

                button_19.setBackgroundResource(R.drawable.buttonnum)
                button_19.setTextColor(resources.getColor(R.color.white))

                button_20.setBackgroundResource(R.drawable.buttonnum)
                button_20.setTextColor(resources.getColor(R.color.white))

                button_30.setBackgroundResource(R.drawable.buttonnum)
                button_30.setTextColor(resources.getColor(R.color.white))

                button_40.setBackgroundResource(R.drawable.buttonnum)
                button_40.setTextColor(resources.getColor(R.color.white))

                button_50.setBackgroundResource(R.drawable.buttonnum)
                button_50.setTextColor(resources.getColor(R.color.white))

                button_60.setBackgroundResource(R.drawable.buttonnum)
                button_60.setTextColor(resources.getColor(R.color.white))

                button_70.setBackgroundResource(R.drawable.buttonnum)
                button_70.setTextColor(resources.getColor(R.color.white))

                button_80.setBackgroundResource(R.drawable.buttonnum)
                button_80.setTextColor(resources.getColor(R.color.white))
            }


            button_five.setOnClickListener {
                tvNum.text = "5"
                tvNumtext.text = "пять"
                tvNumtr.text = "five"
                gambar.setImageResource(R.mipmap.five)
                soundOn()

                buttonZero.setBackgroundResource(R.drawable.buttonnum)
                buttonZero.setTextColor(resources.getColor(R.color.white))

                button_one.setBackgroundResource(R.drawable.buttonnum)
                button_one.setTextColor(resources.getColor(R.color.white))

                button_two.setBackgroundResource(R.drawable.buttonnum)
                button_two.setTextColor(resources.getColor(R.color.white))

                button_three.setBackgroundResource(R.drawable.buttonnum)
                button_three.setTextColor(resources.getColor(R.color.white))

                button_four.setBackgroundResource(R.drawable.buttonnum)
                button_four.setTextColor(resources.getColor(R.color.white))

                button_five.setBackgroundResource(R.drawable.buttonorange)
                button_five.setTextColor(resources.getColor(R.color.colorPrimaryDark))

                button_six.setBackgroundResource(R.drawable.buttonnum)
                button_six.setTextColor(resources.getColor(R.color.white))

                button_seven.setBackgroundResource(R.drawable.buttonnum)
                button_seven.setTextColor(resources.getColor(R.color.white))

                button_eight.setBackgroundResource(R.drawable.buttonnum)
                button_eight.setTextColor(resources.getColor(R.color.white))

                button_nine.setBackgroundResource(R.drawable.buttonnum)
                button_nine.setTextColor(resources.getColor(R.color.white))

                button_ten.setBackgroundResource(R.drawable.buttonnum)
                button_ten.setTextColor(resources.getColor(R.color.white))

                button_eleven.setBackgroundResource(R.drawable.buttonnum)
                button_eleven.setTextColor(resources.getColor(R.color.white))

                button_twelve.setBackgroundResource(R.drawable.buttonnum)
                button_twelve.setTextColor(resources.getColor(R.color.white))

                button_13.setBackgroundResource(R.drawable.buttonnum)
                button_13.setTextColor(resources.getColor(R.color.white))

                button_14.setBackgroundResource(R.drawable.buttonnum)
                button_14.setTextColor(resources.getColor(R.color.white))

                button_15.setBackgroundResource(R.drawable.buttonnum)
                button_15.setTextColor(resources.getColor(R.color.white))

                button_16.setBackgroundResource(R.drawable.buttonnum)
                button_16.setTextColor(resources.getColor(R.color.white))

                button_17.setBackgroundResource(R.drawable.buttonnum)
                button_17.setTextColor(resources.getColor(R.color.white))

                button_18.setBackgroundResource(R.drawable.buttonnum)
                button_18.setTextColor(resources.getColor(R.color.white))

                button_19.setBackgroundResource(R.drawable.buttonnum)
                button_19.setTextColor(resources.getColor(R.color.white))

                button_20.setBackgroundResource(R.drawable.buttonnum)
                button_20.setTextColor(resources.getColor(R.color.white))

                button_30.setBackgroundResource(R.drawable.buttonnum)
                button_30.setTextColor(resources.getColor(R.color.white))

                button_40.setBackgroundResource(R.drawable.buttonnum)
                button_40.setTextColor(resources.getColor(R.color.white))

                button_50.setBackgroundResource(R.drawable.buttonnum)
                button_50.setTextColor(resources.getColor(R.color.white))

                button_60.setBackgroundResource(R.drawable.buttonnum)
                button_60.setTextColor(resources.getColor(R.color.white))

                button_70.setBackgroundResource(R.drawable.buttonnum)
                button_70.setTextColor(resources.getColor(R.color.white))

                button_80.setBackgroundResource(R.drawable.buttonnum)
                button_80.setTextColor(resources.getColor(R.color.white))
            }


            button_six.setOnClickListener {
                tvNum.text = "6"
                tvNumtext.text = "шесть"
                tvNumtr.text = "six"
                gambar.setImageResource(R.mipmap.six)
                soundOn()

                buttonZero.setBackgroundResource(R.drawable.buttonnum)
                buttonZero.setTextColor(resources.getColor(R.color.white))

                button_one.setBackgroundResource(R.drawable.buttonnum)
                button_one.setTextColor(resources.getColor(R.color.white))

                button_two.setBackgroundResource(R.drawable.buttonnum)
                button_two.setTextColor(resources.getColor(R.color.white))

                button_three.setBackgroundResource(R.drawable.buttonnum)
                button_three.setTextColor(resources.getColor(R.color.white))

                button_four.setBackgroundResource(R.drawable.buttonnum)
                button_four.setTextColor(resources.getColor(R.color.white))

                button_five.setBackgroundResource(R.drawable.buttonnum)
                button_five.setTextColor(resources.getColor(R.color.white))

                button_six.setBackgroundResource(R.drawable.buttonorange)
                button_six.setTextColor(resources.getColor(R.color.colorPrimaryDark))

                button_seven.setBackgroundResource(R.drawable.buttonnum)
                button_seven.setTextColor(resources.getColor(R.color.white))

                button_eight.setBackgroundResource(R.drawable.buttonnum)
                button_eight.setTextColor(resources.getColor(R.color.white))

                button_nine.setBackgroundResource(R.drawable.buttonnum)
                button_nine.setTextColor(resources.getColor(R.color.white))

                button_ten.setBackgroundResource(R.drawable.buttonnum)
                button_ten.setTextColor(resources.getColor(R.color.white))

                button_eleven.setBackgroundResource(R.drawable.buttonnum)
                button_eleven.setTextColor(resources.getColor(R.color.white))

                button_twelve.setBackgroundResource(R.drawable.buttonnum)
                button_twelve.setTextColor(resources.getColor(R.color.white))

                button_13.setBackgroundResource(R.drawable.buttonnum)
                button_13.setTextColor(resources.getColor(R.color.white))

                button_14.setBackgroundResource(R.drawable.buttonnum)
                button_14.setTextColor(resources.getColor(R.color.white))

                button_15.setBackgroundResource(R.drawable.buttonnum)
                button_15.setTextColor(resources.getColor(R.color.white))

                button_16.setBackgroundResource(R.drawable.buttonnum)
                button_16.setTextColor(resources.getColor(R.color.white))

                button_17.setBackgroundResource(R.drawable.buttonnum)
                button_17.setTextColor(resources.getColor(R.color.white))

                button_18.setBackgroundResource(R.drawable.buttonnum)
                button_18.setTextColor(resources.getColor(R.color.white))

                button_19.setBackgroundResource(R.drawable.buttonnum)
                button_19.setTextColor(resources.getColor(R.color.white))

                button_20.setBackgroundResource(R.drawable.buttonnum)
                button_20.setTextColor(resources.getColor(R.color.white))

                button_30.setBackgroundResource(R.drawable.buttonnum)
                button_30.setTextColor(resources.getColor(R.color.white))

                button_40.setBackgroundResource(R.drawable.buttonnum)
                button_40.setTextColor(resources.getColor(R.color.white))

                button_50.setBackgroundResource(R.drawable.buttonnum)
                button_50.setTextColor(resources.getColor(R.color.white))

                button_60.setBackgroundResource(R.drawable.buttonnum)
                button_60.setTextColor(resources.getColor(R.color.white))

                button_70.setBackgroundResource(R.drawable.buttonnum)
                button_70.setTextColor(resources.getColor(R.color.white))

                button_80.setBackgroundResource(R.drawable.buttonnum)
                button_80.setTextColor(resources.getColor(R.color.white))
            }


            button_seven.setOnClickListener {
                tvNum.text = "7"
                tvNumtext.text = "семь"
                tvNumtr.text = "seven"
                gambar.setImageResource(R.mipmap.seven)
                soundOn()

                buttonZero.setBackgroundResource(R.drawable.buttonnum)
                buttonZero.setTextColor(resources.getColor(R.color.white))

                button_one.setBackgroundResource(R.drawable.buttonnum)
                button_one.setTextColor(resources.getColor(R.color.white))

                button_two.setBackgroundResource(R.drawable.buttonnum)
                button_two.setTextColor(resources.getColor(R.color.white))

                button_three.setBackgroundResource(R.drawable.buttonnum)
                button_three.setTextColor(resources.getColor(R.color.white))

                button_four.setBackgroundResource(R.drawable.buttonnum)
                button_four.setTextColor(resources.getColor(R.color.white))

                button_five.setBackgroundResource(R.drawable.buttonnum)
                button_five.setTextColor(resources.getColor(R.color.white))

                button_six.setBackgroundResource(R.drawable.buttonnum)
                button_six.setTextColor(resources.getColor(R.color.colorPrimaryDark))

                button_seven.setBackgroundResource(R.drawable.buttonorange)
                button_seven.setTextColor(resources.getColor(R.color.white))

                button_eight.setBackgroundResource(R.drawable.buttonnum)
                button_eight.setTextColor(resources.getColor(R.color.white))

                button_nine.setBackgroundResource(R.drawable.buttonnum)
                button_nine.setTextColor(resources.getColor(R.color.white))

                button_ten.setBackgroundResource(R.drawable.buttonnum)
                button_ten.setTextColor(resources.getColor(R.color.white))

                button_eleven.setBackgroundResource(R.drawable.buttonnum)
                button_eleven.setTextColor(resources.getColor(R.color.white))

                button_twelve.setBackgroundResource(R.drawable.buttonnum)
                button_twelve.setTextColor(resources.getColor(R.color.white))

                button_13.setBackgroundResource(R.drawable.buttonnum)
                button_13.setTextColor(resources.getColor(R.color.white))

                button_14.setBackgroundResource(R.drawable.buttonnum)
                button_14.setTextColor(resources.getColor(R.color.white))

                button_15.setBackgroundResource(R.drawable.buttonnum)
                button_15.setTextColor(resources.getColor(R.color.white))

                button_16.setBackgroundResource(R.drawable.buttonnum)
                button_16.setTextColor(resources.getColor(R.color.white))

                button_17.setBackgroundResource(R.drawable.buttonnum)
                button_17.setTextColor(resources.getColor(R.color.white))

                button_18.setBackgroundResource(R.drawable.buttonnum)
                button_18.setTextColor(resources.getColor(R.color.white))

                button_19.setBackgroundResource(R.drawable.buttonnum)
                button_19.setTextColor(resources.getColor(R.color.white))

                button_20.setBackgroundResource(R.drawable.buttonnum)
                button_20.setTextColor(resources.getColor(R.color.white))

                button_30.setBackgroundResource(R.drawable.buttonnum)
                button_30.setTextColor(resources.getColor(R.color.white))

                button_40.setBackgroundResource(R.drawable.buttonnum)
                button_40.setTextColor(resources.getColor(R.color.white))

                button_50.setBackgroundResource(R.drawable.buttonnum)
                button_50.setTextColor(resources.getColor(R.color.white))

                button_60.setBackgroundResource(R.drawable.buttonnum)
                button_60.setTextColor(resources.getColor(R.color.white))

                button_70.setBackgroundResource(R.drawable.buttonnum)
                button_70.setTextColor(resources.getColor(R.color.white))

                button_80.setBackgroundResource(R.drawable.buttonnum)
                button_80.setTextColor(resources.getColor(R.color.white))
            }


            button_eight.setOnClickListener {
                tvNum.text = "8"
                tvNumtext.text = "восемь"
                tvNumtr.text = "Eight"
                gambar.setImageResource(R.mipmap.eight)
                soundOn()

                buttonZero.setBackgroundResource(R.drawable.buttonnum)
                buttonZero.setTextColor(resources.getColor(R.color.white))

                button_one.setBackgroundResource(R.drawable.buttonnum)
                button_one.setTextColor(resources.getColor(R.color.white))

                button_two.setBackgroundResource(R.drawable.buttonnum)
                button_two.setTextColor(resources.getColor(R.color.colorPrimaryDark))

                button_three.setBackgroundResource(R.drawable.buttonnum)
                button_three.setTextColor(resources.getColor(R.color.white))

                button_four.setBackgroundResource(R.drawable.buttonnum)
                button_four.setTextColor(resources.getColor(R.color.white))

                button_five.setBackgroundResource(R.drawable.buttonnum)
                button_five.setTextColor(resources.getColor(R.color.white))

                button_six.setBackgroundResource(R.drawable.buttonnum)
                button_six.setTextColor(resources.getColor(R.color.white))

                button_seven.setBackgroundResource(R.drawable.buttonnum)
                button_seven.setTextColor(resources.getColor(R.color.white))

                button_eight.setBackgroundResource(R.drawable.buttonorange)
                button_eight.setTextColor(resources.getColor(R.color.colorPrimaryDark))

                button_nine.setBackgroundResource(R.drawable.buttonnum)
                button_nine.setTextColor(resources.getColor(R.color.white))

                button_ten.setBackgroundResource(R.drawable.buttonnum)
                button_ten.setTextColor(resources.getColor(R.color.white))

                button_eleven.setBackgroundResource(R.drawable.buttonnum)
                button_eleven.setTextColor(resources.getColor(R.color.white))

                button_twelve.setBackgroundResource(R.drawable.buttonnum)
                button_twelve.setTextColor(resources.getColor(R.color.white))

                button_13.setBackgroundResource(R.drawable.buttonnum)
                button_13.setTextColor(resources.getColor(R.color.white))

                button_14.setBackgroundResource(R.drawable.buttonnum)
                button_14.setTextColor(resources.getColor(R.color.white))

                button_15.setBackgroundResource(R.drawable.buttonnum)
                button_15.setTextColor(resources.getColor(R.color.white))

                button_16.setBackgroundResource(R.drawable.buttonnum)
                button_16.setTextColor(resources.getColor(R.color.white))

                button_17.setBackgroundResource(R.drawable.buttonnum)
                button_17.setTextColor(resources.getColor(R.color.white))

                button_18.setBackgroundResource(R.drawable.buttonnum)
                button_18.setTextColor(resources.getColor(R.color.white))

                button_19.setBackgroundResource(R.drawable.buttonnum)
                button_19.setTextColor(resources.getColor(R.color.white))

                button_20.setBackgroundResource(R.drawable.buttonnum)
                button_20.setTextColor(resources.getColor(R.color.white))

                button_30.setBackgroundResource(R.drawable.buttonnum)
                button_30.setTextColor(resources.getColor(R.color.white))

                button_40.setBackgroundResource(R.drawable.buttonnum)
                button_40.setTextColor(resources.getColor(R.color.white))

                button_50.setBackgroundResource(R.drawable.buttonnum)
                button_50.setTextColor(resources.getColor(R.color.white))

                button_60.setBackgroundResource(R.drawable.buttonnum)
                button_60.setTextColor(resources.getColor(R.color.white))

                button_70.setBackgroundResource(R.drawable.buttonnum)
                button_70.setTextColor(resources.getColor(R.color.white))

                button_80.setBackgroundResource(R.drawable.buttonnum)
                button_80.setTextColor(resources.getColor(R.color.white))
            }
        }

    }

    private fun soundOn(){
        when(tv_num.text){
            "0" -> {
                val player = MediaPlayer.create(context, R.raw.zero)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }

            "1" -> {
                val player = MediaPlayer.create(context, R.raw.one)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }

            "2" -> {
                val player = MediaPlayer.create(context, R.raw.two)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }

            "3" -> {
                val player = MediaPlayer.create(context, R.raw.three)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }

            "4" -> {
                val player = MediaPlayer.create(context, R.raw.four)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }

            "5" -> {
                val player = MediaPlayer.create(context, R.raw.five)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }

            "6" -> {
                val player = MediaPlayer.create(context, R.raw.six)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }

            "7" -> {
                val player = MediaPlayer.create(context, R.raw.seven)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
            "8" -> {
                val player = MediaPlayer.create(context, R.raw.eight)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
            "9" -> {
                val player = MediaPlayer.create(context, R.raw.nine)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
            "10" -> {
                val player = MediaPlayer.create(context, R.raw.ten)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
            "11" -> {
                val player = MediaPlayer.create(context, R.raw.eleven)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
            "12" -> {
                val player = MediaPlayer.create(context, R.raw.tvt)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
            "13" -> {
                val player = MediaPlayer.create(context, R.raw.threeteen)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
            "14" -> {
                val player = MediaPlayer.create(context, R.raw.fourteen)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }
            "15" -> {
                val player = MediaPlayer.create(context, R.raw.fiveteen)
                player.start()
                player.setOnCompletionListener {
                    player.release()
                }
            }



            else -> {
                val player = MediaPlayer.create(context, R.raw.one)
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

        private const val NUMBER_FRAGMENT_TAG = "NUMBER_FRAGMENT_TAG"

        fun getInstance(message: String)
                = HandwritingFragment().apply {
            arguments = Bundle().apply {
                putString(NUMBER_FRAGMENT_TAG,message)

            }
        }
    }

}