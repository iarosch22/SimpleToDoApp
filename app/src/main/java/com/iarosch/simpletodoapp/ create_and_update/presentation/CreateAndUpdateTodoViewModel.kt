package com.iarosch.simpletodoapp.create_and_update.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iarosch.simpletodoapp.core.domain.model.Todo
import com.iarosch.simpletodoapp.create_and_update.domain.AddTodoUseCase
import com.iarosch.simpletodoapp.create_and_update.domain.GetTodoByIdUseCase
import com.iarosch.simpletodoapp.create_and_update.domain.UpdateTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class CreateAndUpdateTodoViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val updateTodoUseCase: UpdateTodoUseCase,
    private val getTodoByIdUseCase: GetTodoByIdUseCase,
    private val addTodoUseCase: AddTodoUseCase
) : ViewModel() {

    private val noteId: String? = savedStateHandle[TODO_ID_ARG]

    init {
        if (noteId != null) loadNote(noteId = noteId.toInt())
    }

    private val _uiState = MutableStateFlow<CreateAndUpdateTodoUiState>(
        CreateAndUpdateTodoUiState.Content()
    )
    val uiState = _uiState.asStateFlow()

    fun handleEvent(event: CreateAndUpdateTodoUiEvent) {
        when (event) {
            is CreateAndUpdateTodoUiEvent.OnTitleChanged -> setTitle(event.title)
            is CreateAndUpdateTodoUiEvent.OnDescriptionChanged -> setDescription(event.description)
            is CreateAndUpdateTodoUiEvent.OnSaveClicked -> addOrUpdateNote(noteId)
        }
    }

    private fun loadNote(noteId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val note = getTodoByIdUseCase(noteId).first()
            _uiState.update {
                CreateAndUpdateTodoUiState.Content(
                    id = noteId,
                    title = note.title,
                    description = note.description
                )
            }
        }
    }

    private fun setTitle(title: String) {
        _uiState.update {
            (it as CreateAndUpdateTodoUiState.Content).copy(title = title)
        }
    }

    private fun setDescription(description: String) {
        _uiState.update {
            (it as CreateAndUpdateTodoUiState.Content).copy(description = description)
        }
    }

    private fun addOrUpdateNote(noteId: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            val state = _uiState.value as CreateAndUpdateTodoUiState.Content
            val note = Todo(
                id = state.id,
                title = state.title,
                description = state.description
            )

            if (noteId != null) {
                updateTodoUseCase(note)
            } else addTodoUseCase(note)
        }
    }
}