package com.iarosch.simpletodoapp.home.domain

import com.iarosch.simpletodoapp.core.domain.model.Todo

interface DeleteTodoUseCase {

    suspend operator fun invoke(todo: Todo)

}