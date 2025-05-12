package com.iarosch.simpletodoapp.create_and_update.domain.impl

import com.iarosch.simpletodoapp.core.domain.LocalDataSourceRepository
import com.iarosch.simpletodoapp.create_and_update.domain.GetTodoByIdUseCase
import javax.inject.Inject

class GetTodoByIdUseCaseImpl @Inject constructor(
    private val localDataSourceRepository: LocalDataSourceRepository
): GetTodoByIdUseCase {

    override operator fun invoke(id: Int) =
        localDataSourceRepository.getTodoByIdFlow(id)
}