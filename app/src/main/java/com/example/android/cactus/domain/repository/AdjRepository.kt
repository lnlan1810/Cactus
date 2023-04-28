package com.example.android.cactus.domain.repository

import com.example.android.cactus.R
import com.example.android.cactus.domain.model.CommonWord


object AdjRepository {
    var id = 0;

    val commonWords = arrayListOf(
        CommonWord(
            id++, "большой",
            R.string.big,"Мне не нравятся большие настольные лампы.", R.drawable.big, R.raw.eight),
        CommonWord(id++, "маленький", R.string.samll, "маленький цыпленок", R.drawable.small , R.raw.eight),
        CommonWord(id++, "хороший", R.string.good,"хорошо для тела", R.drawable.good , R.raw.sat),
        CommonWord(id++, "красивый", R.string.beautifu, "красивая актриса", R.drawable.beautiful , R.raw.sat),

        CommonWord(
            id++, "большой",
            R.string.big,"Мне не нравятся большие настольные лампы.", R.drawable.big, R.raw.eight),
        CommonWord(id++, "маленький", R.string.samll, "маленький цыпленок", R.drawable.small , R.raw.eight),
        CommonWord(id++, "хороший", R.string.good,"хорошо для тела", R.drawable.good , R.raw.sat),
        CommonWord(id++, "красивый", R.string.beautifu, "красивая актриса", R.drawable.beautiful , R.raw.sat),

        CommonWord(
            id++, "большой",
            R.string.big,"Мне не нравятся большие настольные лампы.", R.drawable.big, R.raw.eight),
        CommonWord(id++, "маленький", R.string.samll, "маленький цыпленок", R.drawable.small , R.raw.eight),
        CommonWord(id++, "хороший", R.string.good,"хорошо для тела", R.drawable.good , R.raw.sat),
        CommonWord(id++, "красивый", R.string.beautifu, "красивая актриса", R.drawable.beautiful , R.raw.sat),

        CommonWord(
            id++, "большой",
            R.string.big,"Мне не нравятся большие настольные лампы.", R.drawable.big, R.raw.eight),
        CommonWord(id++, "маленький", R.string.samll, "маленький цыпленок", R.drawable.small , R.raw.eight),
        CommonWord(id++, "хороший", R.string.good,"хорошо для тела", R.drawable.good , R.raw.sat),
        CommonWord(id++, "красивый", R.string.beautifu, "красивая актриса", R.drawable.beautiful , R.raw.sat),
    )
}