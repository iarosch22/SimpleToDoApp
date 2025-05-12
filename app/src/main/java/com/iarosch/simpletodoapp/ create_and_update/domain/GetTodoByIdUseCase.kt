package com.iarosch.simpletodoapp.create_and_update.domain

import com.iarosch.simpletodoapp.core.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface GetTodoByIdUseCase {

    operator fun invoke(id: Int): Flow<Todo>

}