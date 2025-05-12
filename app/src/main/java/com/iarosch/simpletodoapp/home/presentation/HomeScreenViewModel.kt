package com.iarosch.simpletodoapp.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iarosch.simpletodoapp.core.domain.model.Todo
import com.iarosch.simpletodoapp.home.domain.DeleteTodoUseCase
import com.iarosch.simpletodoapp.home.domain.GetAllTodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
internal class HomeViewModel @Inject constructor(
    private val deleteTodoUseCase: DeleteTodoUseCase,
    getAllTodoUseCase: GetAllTodoUseCase
) : ViewModel() {

    fun handleEvent(event: HomeScreenUiEvent) {
        when (event) {
            is HomeScreenUiEvent.OnDeleteClick -> deleteTodo(event.todo)
        }
    }

    private val todoList = getAllTodoUseCase()

    val uiState: StateFlow<HomeScreenUiState> = todoList.map { list ->
        if (list.isNotEmpty())
            HomeScreenUiState.Content(list)
        else HomeScreenUiState.Empty
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = HomeScreenUiState.Empty
    )

    private fun deleteTodo(todo: Todo) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteTodoUseCase(todo)
        }
    }
}