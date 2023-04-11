package com.example.android.cactus.homeScreen.domain

import com.example.android.cactus.R
import com.example.android.cactus.homeScreen.domain.model.Word

object WordRepository {

    var id = 0;

    val words = arrayListOf(
        Word(id++, "год", R.string.year, "Как ты думаешь, какой рост будет у моей дочери через три года?", R.drawable.year , R.raw.year),
        Word(id++, "время", R.string.time,"ом никогда не забудет о времени, проведённом с Мэри", R.drawable.time , R.raw.time),
        Word(id++, "человек",R.string.man,"Нет, я не могу Вас впустить, это будет на одного человека больше положенного количества.", R.drawable.person, R.raw.person),
        Word(id++, "рука", R.string.hand, "У меня нет подходящей литературы под рукой.", R.drawable.hand , R.raw.hand),

        Word(id++, "год", R.string.year, "Как ты думаешь, какой рост будет у моей дочери через три года?", R.drawable.year , R.raw.year),
        Word(id++, "время", R.string.time,"ом никогда не забудет о времени, проведённом с Мэри", R.drawable.time , R.raw.time),
        Word(id++, "человек",R.string.man,"Нет, я не могу Вас впустить, это будет на одного человека больше положенного количества.", R.drawable.person, R.raw.person),
        Word(id++, "рука", R.string.hand, "У меня нет подходящей литературы под рукой.", R.drawable.hand , R.raw.hand),

        Word(id++, "год", R.string.year, "Как ты думаешь, какой рост будет у моей дочери через три года?", R.drawable.year , R.raw.year),
        Word(id++, "время", R.string.time,"ом никогда не забудет о времени, проведённом с Мэри", R.drawable.time , R.raw.time),
        Word(id++, "человек",R.string.man,"Нет, я не могу Вас впустить, это будет на одного человека больше положенного количества.", R.drawable.person, R.raw.person),
        Word(id++, "рука", R.string.hand, "У меня нет подходящей литературы под рукой.", R.drawable.hand , R.raw.hand),

        )
}