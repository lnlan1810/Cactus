package com.example.android.cactus.presentation.viewmodel

import androidx.lifecycle.*
import com.example.android.cactus.domain.model.Category
import com.example.android.cactus.domain.model.Word
import com.example.android.cactus.domain.repository.CategoryRepository
import com.example.android.cactus.domain.repository.WordsRepository
import com.example.android.cactus.domain.utils.DispatcherProvider
import kotlinx.coroutines.launch

class WordsViewModel(
    private val repoWord: WordsRepository,
    private val repoCategory: CategoryRepository,
    private val dispatchers: DispatcherProvider
) : ViewModel(),
    DefaultLifecycleObserver {

    val wordsOfCategory: LiveData<List<Word>>
        get() = _wordsOfCategory

    val category: LiveData<Category>
        get() = _category

    private var _category = MutableLiveData<Category>()
    private var _wordsOfCategory = MutableLiveData<List<Word>>()

    init {
        getWordsOfCategory()
    }

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        getWordsOfCategory()
        getAllCategories()
    }

    fun setSelectedCategory(category: Category) {
        _category.value = category
    }

    private fun getAllCategories() =
        viewModelScope.launch(dispatchers.io) {
            repoCategory.getCategories()
        }

    private fun getWordsOfCategory() =
        viewModelScope.launch(dispatchers.io) {
            val words = _category.value?.id?.let { repoWord.getWordsOfCategory(it) }

            _wordsOfCategory.postValue(words)
        }

    fun deleteCategory() =
        viewModelScope.launch(dispatchers.io) {
            _category.value?.let {
                repoCategory.deleteCategory(it)
                repoWord.deleteWordsOfCategory(it.id)
            }
        }

    fun deleteWord(position: Int) =
        viewModelScope.launch(dispatchers.io) {
            _wordsOfCategory.value?.get(position)?.let { repoWord.deleteWord(it) }
            getWordsOfCategory()
        }

    fun updateCategory(newName: String) =
        viewModelScope.launch(dispatchers.io) {

            _category.value?.name = newName

            _category.value?.let { repoCategory.updateCategory(it) }
        }
}












