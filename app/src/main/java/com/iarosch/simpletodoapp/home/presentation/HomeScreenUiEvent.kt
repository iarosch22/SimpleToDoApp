package com.iarosch.simpletodoapp.home.presentation

import com.iarosch.simpletodoapp.core.domain.model.Todo

internal sealed interface HomeScreenUiEvent {

    data class OnDeleteClick(val todo: Todo) : HomeScreenUiEvent

}