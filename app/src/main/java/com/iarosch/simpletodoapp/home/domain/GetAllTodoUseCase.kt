package com.iarosch.simpletodoapp.home.domain

import com.iarosch.simpletodoapp.core.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface GetAllTodoUseCase {

    operator fun invoke(): Flow<List<Todo>>

}