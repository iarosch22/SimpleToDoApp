package com.iarosch.simpletodoapp.create_and_update.domain

import com.iarosch.simpletodoapp.core.domain.model.Todo

interface UpdateTodoUseCase {

    suspend operator fun invoke(todo: Todo)

}