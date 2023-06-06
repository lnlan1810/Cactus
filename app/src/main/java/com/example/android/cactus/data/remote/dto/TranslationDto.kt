package com.example.android.cactus.data.remote.dto

import androidx.annotation.Keep
import com.example.android.cactus.domain.model.entity.TranslationWord
import com.example.android.cactus.domain.model.entity.Translation
import com.google.gson.annotations.SerializedName

@Keep
data class TranslationDto(
    @SerializedName("def")
    val def: List<Definition>,
)
{
    fun toEntity(): Translation {
        var translationWords: MutableList<TranslationWord> = mutableListOf()
        for (definition in def) {
            val translations: MutableList<String> = mutableListOf()

            if (definition.tr == null) {
                continue
            }

            for (translation in definition.tr) {
                translations.add(translation.text)

                if (translation.syn == null) {
                    continue
                }

                for (synonym in translation.syn) {
                    translations.add(synonym.text)
                }
            }

            translationWords.add(
                TranslationWord(
                    word = definition.text,
                    type = definition.pos,
                    translation = translations
                )
            )
        }

        return Translation(translationWords)
    }
}