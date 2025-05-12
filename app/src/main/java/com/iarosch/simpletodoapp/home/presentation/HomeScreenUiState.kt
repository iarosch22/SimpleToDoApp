package com.iarosch.simpletodoapp.home.presentation

import com.iarosch.simpletodoapp.core.domain.model.Todo

internal sealed interface HomeScreenUiState {

    data object Empty: HomeScreenUiState
    data class Content(val todoList: List<Todo>): HomeScreenUiState

}