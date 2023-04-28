package com.example.android.cactus.domain.repository

import com.example.android.cactus.R
import com.example.android.cactus.domain.model.CommonWord

object WordRepository {

    var id = 0;

    val words = arrayListOf(
        CommonWord(id++, "год", R.string.year, "Как ты думаешь, какой рост будет у моей дочери через три года?", R.drawable.year , R.raw.year),
        CommonWord(id++, "время", R.string.time,"ом никогда не забудет о времени, проведённом с Мэри", R.drawable.time , R.raw.time),
        CommonWord(id++, "человек",R.string.man,"Нет, я не могу Вас впустить, это будет на одного человека больше положенного количества.", R.drawable.person, R.raw.person),
        CommonWord(id++, "рука", R.string.hand, "У меня нет подходящей литературы под рукой.", R.drawable.hand , R.raw.hand),

        CommonWord(id++, "год", R.string.year, "Как ты думаешь, какой рост будет у моей дочери через три года?", R.drawable.year , R.raw.year),
        CommonWord(id++, "время", R.string.time,"ом никогда не забудет о времени, проведённом с Мэри", R.drawable.time , R.raw.time),
        CommonWord(id++, "человек",R.string.man,"Нет, я не могу Вас впустить, это будет на одного человека больше положенного количества.", R.drawable.person, R.raw.person),
        CommonWord(id++, "рука", R.string.hand, "У меня нет подходящей литературы под рукой.", R.drawable.hand , R.raw.hand),

        CommonWord(id++, "год", R.string.year, "Как ты думаешь, какой рост будет у моей дочери через три года?", R.drawable.year , R.raw.year),
        CommonWord(id++, "время", R.string.time,"ом никогда не забудет о времени, проведённом с Мэри", R.drawable.time , R.raw.time),
        CommonWord(id++, "человек",R.string.man,"Нет, я не могу Вас впустить, это будет на одного человека больше положенного количества.", R.drawable.person, R.raw.person),
        CommonWord(id++, "рука", R.string.hand, "У меня нет подходящей литературы под рукой.", R.drawable.hand , R.raw.hand),

        )
}