package com.example.android.cactus.domain.repository

import com.example.android.cactus.R
import com.example.android.cactus.domain.model.Number

object NumberRepository {
    val numbers = arrayListOf<Number>(
        Number(0,"0","нуль","zero", R.mipmap.zero, R.raw.zero ),
        Number(1,"1","один","one", R.mipmap.one, R.raw.one ),
        Number(2,"2","два","two", R.mipmap.two, R.raw.two ),
        Number(3,"3","три","three", R.mipmap.three, R.raw.three ),
        Number(4,"4","четыре","four", R.mipmap.four, R.raw.four ),
        Number(5,"5","пять","five", R.mipmap.five, R.raw.five ),
        Number(6,"6","шесть","six", R.mipmap.six, R.raw.six ),
        Number(7,"7","семь","seven", R.mipmap.seven, R.raw.seven ),
        Number(8,"8","восемь","eight", R.mipmap.eight, R.raw.eight ),
        Number(9,"9","девять","nine", R.mipmap.nine, R.raw.nine ),
        Number(10,"10","десять","ten", R.mipmap.ten, R.raw.ten ),
        )

    fun getNumber(number_id: Int): Number? {
        numbers.forEach{
            if(it.id == number_id)
                return it
        }
        return null
    }
}

