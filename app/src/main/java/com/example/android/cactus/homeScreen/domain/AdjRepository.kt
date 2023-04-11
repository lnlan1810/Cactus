package com.example.android.cactus.homeScreen.domain

import com.example.android.cactus.R
import com.example.android.cactus.homeScreen.domain.model.Word


object AdjRepository {
    var id = 0;

    val words = arrayListOf(
        Word(id++, "большой",
            R.string.big,"Мне не нравятся большие настольные лампы.", R.drawable.big, R.raw.eight),
        Word(id++, "маленький", R.string.samll, "маленький цыпленок", R.drawable.small , R.raw.eight),
        Word(id++, "хороший", R.string.good,"хорошо для тела", R.drawable.good , R.raw.sat),
        Word(id++, "красивый", R.string.beautifu, "красивая актриса", R.drawable.beautiful , R.raw.sat),

        Word(id++, "большой",
            R.string.big,"Мне не нравятся большие настольные лампы.", R.drawable.big, R.raw.eight),
        Word(id++, "маленький", R.string.samll, "маленький цыпленок", R.drawable.small , R.raw.eight),
        Word(id++, "хороший", R.string.good,"хорошо для тела", R.drawable.good , R.raw.sat),
        Word(id++, "красивый", R.string.beautifu, "красивая актриса", R.drawable.beautiful , R.raw.sat),

        Word(id++, "большой",
            R.string.big,"Мне не нравятся большие настольные лампы.", R.drawable.big, R.raw.eight),
        Word(id++, "маленький", R.string.samll, "маленький цыпленок", R.drawable.small , R.raw.eight),
        Word(id++, "хороший", R.string.good,"хорошо для тела", R.drawable.good , R.raw.sat),
        Word(id++, "красивый", R.string.beautifu, "красивая актриса", R.drawable.beautiful , R.raw.sat),

        Word(id++, "большой",
            R.string.big,"Мне не нравятся большие настольные лампы.", R.drawable.big, R.raw.eight),
        Word(id++, "маленький", R.string.samll, "маленький цыпленок", R.drawable.small , R.raw.eight),
        Word(id++, "хороший", R.string.good,"хорошо для тела", R.drawable.good , R.raw.sat),
        Word(id++, "красивый", R.string.beautifu, "красивая актриса", R.drawable.beautiful , R.raw.sat),
    )
}