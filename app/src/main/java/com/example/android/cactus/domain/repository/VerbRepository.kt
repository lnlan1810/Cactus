package com.example.android.cactus.domain.repository

import com.example.android.cactus.R
import com.example.android.cactus.domain.model.CommonWord


object VerbRepository {
    var id = 0;

    val words = arrayListOf(
        CommonWord(
            id++, "быть",
            R.string.tobe,"Хотел бы я, чтобы у меня было больше времени", R.drawable.tobe, R.raw.tobe),
        CommonWord(id++, "сказать", R.string.tosay, "Я поклялся, что никогда никому не скажу.", R.drawable.say , R.raw.say),
        CommonWord(id++, "мочь", R.string.beable,"Вы можете порекомендовать мне место в Лондоне, где я мог бы остановиться?", R.drawable.beable , R.raw.beable),
        CommonWord(id++, "говорить", R.string.say, "Том говорит, что вы трое — его братья.", R.drawable.tell , R.raw.tell),

        CommonWord(
            id++, "быть",
            R.string.tobe,"Хотел бы я, чтобы у меня было больше времени", R.drawable.tobe, R.raw.tobe),
        CommonWord(id++, "сказать", R.string.tosay, "Я поклялся, что никогда никому не скажу.", R.drawable.say , R.raw.say),
        CommonWord(id++, "мочь", R.string.beable,"Вы можете порекомендовать мне место в Лондоне, где я мог бы остановиться?", R.drawable.beable , R.raw.beable),
        CommonWord(id++, "говорить", R.string.say, "Том говорит, что вы трое — его братья.", R.drawable.tell , R.raw.tell),

        CommonWord(
            id++, "быть",
            R.string.tobe,"Хотел бы я, чтобы у меня было больше времени", R.drawable.tobe, R.raw.tobe),
        CommonWord(id++, "сказать", R.string.tosay, "Я поклялся, что никогда никому не скажу.", R.drawable.say , R.raw.say),
        CommonWord(id++, "мочь", R.string.beable,"Вы можете порекомендовать мне место в Лондоне, где я мог бы остановиться?", R.drawable.beable , R.raw.beable),
        CommonWord(id++, "говорить", R.string.say, "Том говорит, что вы трое — его братья.", R.drawable.tell , R.raw.tell),
    )
}