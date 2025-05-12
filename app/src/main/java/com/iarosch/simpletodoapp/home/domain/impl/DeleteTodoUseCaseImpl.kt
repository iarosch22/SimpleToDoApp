package com.iarosch.simpletodoapp.home.domain.impl

import com.iarosch.simpletodoapp.core.domain.LocalDataSourceRepository
import com.iarosch.simpletodoapp.core.domain.model.Todo
import com.iarosch.simpletodoapp.home.domain.DeleteTodoUseCase
import javax.inject.Inject

class DeleteTodoUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): DeleteTodoUseCase {

    override suspend operator fun invoke(todo: Todo) {
        localDataSourceRepository.deleteTodo(todo)
    }
}