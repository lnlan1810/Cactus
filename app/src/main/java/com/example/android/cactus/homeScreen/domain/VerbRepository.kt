package com.example.android.cactus.homeScreen.domain

import com.example.android.cactus.R
import com.example.android.cactus.homeScreen.domain.model.Word


object VerbRepository {
    var id = 0;

    val words = arrayListOf(
        Word(id++, "быть",
            R.string.tobe,"Хотел бы я, чтобы у меня было больше времени", R.drawable.tobe, R.raw.tobe),
        Word(id++, "сказать", R.string.tosay, "Я поклялся, что никогда никому не скажу.", R.drawable.say , R.raw.say),
        Word(id++, "мочь", R.string.beable,"Вы можете порекомендовать мне место в Лондоне, где я мог бы остановиться?", R.drawable.beable , R.raw.beable),
        Word(id++, "говорить", R.string.say, "Том говорит, что вы трое — его братья.", R.drawable.tell , R.raw.tell),

        Word(id++, "быть",
            R.string.tobe,"Хотел бы я, чтобы у меня было больше времени", R.drawable.tobe, R.raw.tobe),
        Word(id++, "сказать", R.string.tosay, "Я поклялся, что никогда никому не скажу.", R.drawable.say , R.raw.say),
        Word(id++, "мочь", R.string.beable,"Вы можете порекомендовать мне место в Лондоне, где я мог бы остановиться?", R.drawable.beable , R.raw.beable),
        Word(id++, "говорить", R.string.say, "Том говорит, что вы трое — его братья.", R.drawable.tell , R.raw.tell),

        Word(id++, "быть",
            R.string.tobe,"Хотел бы я, чтобы у меня было больше времени", R.drawable.tobe, R.raw.tobe),
        Word(id++, "сказать", R.string.tosay, "Я поклялся, что никогда никому не скажу.", R.drawable.say , R.raw.say),
        Word(id++, "мочь", R.string.beable,"Вы можете порекомендовать мне место в Лондоне, где я мог бы остановиться?", R.drawable.beable , R.raw.beable),
        Word(id++, "говорить", R.string.say, "Том говорит, что вы трое — его братья.", R.drawable.tell , R.raw.tell),
    )
}