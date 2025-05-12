package com.iarosch.simpletodoapp.home.domain.impl

import com.iarosch.simpletodoapp.core.domain.LocalDataSourceRepository
import com.iarosch.simpletodoapp.home.domain.GetAllTodoUseCase
import javax.inject.Inject

class GetAllTodoUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): GetAllTodoUseCase {

    override operator fun invoke() = localDataSourceRepository.getAllNotesFlow()
}