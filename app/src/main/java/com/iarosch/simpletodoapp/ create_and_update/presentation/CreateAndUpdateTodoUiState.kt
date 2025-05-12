package com.iarosch.simpletodoapp.create_and_update.presentation

sealed interface CreateAndUpdateTodoUiState {

    data class Content(
        val id: Int = 0,
        val title: String = "",
        val description: String = ""
    ): CreateAndUpdateTodoUiState

}