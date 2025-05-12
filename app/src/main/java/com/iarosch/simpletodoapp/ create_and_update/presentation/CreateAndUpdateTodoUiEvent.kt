package com.iarosch.simpletodoapp.create_and_update.presentation

internal sealed interface CreateAndUpdateTodoUiEvent {

    data class OnTitleChanged(val title: String): CreateAndUpdateTodoUiEvent
    data class OnDescriptionChanged(val description: String): CreateAndUpdateTodoUiEvent
    data object OnSaveClicked: CreateAndUpdateTodoUiEvent

}