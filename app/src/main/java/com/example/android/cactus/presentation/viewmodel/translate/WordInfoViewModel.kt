package com.example.android.cactus.presentation.viewmodel.translate

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.cactus.domain.common.Resource
import com.example.android.cactus.domain.model.entity.WordTranslationState
import com.example.android.cactus.domain.repository.TranslationRepository
import com.example.android.cactus.domain.utils.UiEvent
import com.example.android.cactus.presentation.translate.WordTranslateEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(
    private val translationRepository: TranslationRepository,
): ViewModel() {

    private val _eventFlow = MutableSharedFlow<UiEvent>()

    var menuExpanded = mutableStateOf(false)
        private set

    var showTranslationDialog = mutableStateOf(false)
        private set

    var newTerm = mutableStateOf("")
        private set

    var editState = mutableStateOf(true)
        private set

    var newDefinition = mutableStateOf("")
        private set

   private val _state = mutableStateOf(WordTranslationState(translation = null, isLoading = false))
    val state: State<WordTranslationState> = _state

    private var searchJob: Job? = null

    fun onEvent(event: WordTranslateEvent) {
        when (event) {
            is WordTranslateEvent.OnMenuClick -> {
                menuExpanded.value = true
            }
            is WordTranslateEvent.OnCloseMenu -> {
                menuExpanded.value = false
            }
           is WordTranslateEvent.OnTermChange -> {
                newTerm.value = event.term
            }
            is WordTranslateEvent.OnDefinitionChange -> {
                newDefinition.value = event.definition
            }
            WordTranslateEvent.OnShowTranslationDialog -> {
                if (newTerm.value.isEmpty()) {
                    viewModelScope.launch(Dispatchers.IO) {
                        _eventFlow.emit(UiEvent.ShowSnackbar("Term is empty"))
                    }
                    return
                }

                showTranslationDialog.value = true
                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    translationRepository.getTranslation(newTerm.value)
                        .onEach { result ->
                            when (result) {
                                is Resource.Success -> {
                                    _state.value = state.value.copy(translation = result.data, isLoading = false)
                                }
                                is Resource.Error -> {
                                    _state.value = state.value.copy(isLoading = false)
                                    _eventFlow.emit(UiEvent.ShowSnackbar(result.message ?: "Unexpected error occurred"))
                                }
                                is Resource.Loading -> {
                                    _state.value = state.value.copy(isLoading = true)
                                }
                            }
                        }.launchIn(this)
                }
            }
            WordTranslateEvent.OnHideTranslationDialog -> {
                searchJob?.cancel()
                showTranslationDialog.value = false
            }
        }
    }

}