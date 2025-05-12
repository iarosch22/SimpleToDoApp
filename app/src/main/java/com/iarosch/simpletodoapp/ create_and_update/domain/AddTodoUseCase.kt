package com.iarosch.simpletodoapp.create_and_update.domain

import com.iarosch.simpletodoapp.core.domain.model.Todo

interface AddTodoUseCase {

    suspend operator fun invoke(todo: Todo)

}