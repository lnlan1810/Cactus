package com.example.android.cactus.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.cactus.domain.model.Category
import com.example.android.cactus.domain.model.Word
import com.example.android.cactus.domain.repository.WordsRepository
import com.example.android.cactus.domain.utils.DispatcherProvider
import kotlinx.coroutines.launch

class AddWordViewModel(
    private val repository: WordsRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel() {

    val word: LiveData<Word>
        get() = _word

    val dataIsValid: LiveData<Boolean>
        get() = _dataIsValid

    val category: LiveData<Category>
        get() = _category

    private var _category = MutableLiveData<Category>()
    private var _word = MutableLiveData<Word>()
    private var _dataIsValid = MutableLiveData<Boolean>()


    fun addOrUpdate(name: String, translation: String) {

        if (categoryIsNotNull() && _word.value == null && inputNotEmpty(name, translation)) {

            addWord(name, translation)
            _dataIsValid.value = true

        } else if (categoryIsNotNull() && _word.value != null && inputNotEmpty(name, translation)) {

            updateWord(name, translation)
            _dataIsValid.value = true

        } else {
            _dataIsValid.value = false
        }
    }

    private fun inputNotEmpty(name: String, translation: String): Boolean =
        name.isNotEmpty() && translation.isNotEmpty()


    private fun updateWord(newName: String, newTranslation: String) {
        viewModelScope.launch(dispatchers.io) {

            _word.value?.apply {
                name = newName
                translation = newTranslation
            }

            _word.value?.let { repository.updateWord(it) }
        }
    }

    private fun addWord(name: String, translation: String) {
        viewModelScope.launch(dispatchers.io) {

            val word = _category.value?.id?.let { Word(0, name, translation, 0, it) }

            word?.let { repository.addWord(word) }
        }
    }

    fun setSelectedCategory(category: Category) {
        _category.value = category
    }

    fun setSelectedWord(word: Word) {
        _word.value = word
    }

    private fun categoryIsNotNull(): Boolean = _category.value?.id != null

}