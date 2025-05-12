package com.iarosch.simpletodoapp.create_and_update.domain.impl

import com.iarosch.simpletodoapp.core.domain.LocalDataSourceRepository
import com.iarosch.simpletodoapp.core.domain.model.Todo
import com.iarosch.simpletodoapp.create_and_update.domain.UpdateTodoUseCase
import javax.inject.Inject

class UpdateTodoUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): UpdateTodoUseCase {

    override suspend operator fun invoke(todo: Todo) = localDataSourceRepository.updateTodo(todo)
}