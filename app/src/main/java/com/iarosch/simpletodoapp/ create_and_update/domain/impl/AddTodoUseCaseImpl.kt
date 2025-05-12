package com.iarosch.simpletodoapp.create_and_update.domain.impl

import com.iarosch.simpletodoapp.core.domain.LocalDataSourceRepository
import com.iarosch.simpletodoapp.core.domain.model.Todo
import com.iarosch.simpletodoapp.create_and_update.domain.AddTodoUseCase
import javax.inject.Inject

class AddTodoUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): AddTodoUseCase {

    override suspend operator fun invoke(todo: Todo) {
        localDataSourceRepository.addTodo(todo)
    }
}