package com.iarosch.simpletodoapp.home.di

import com.iarosch.simpletodoapp.home.domain.DeleteTodoUseCase
import com.iarosch.simpletodoapp.home.domain.GetAllTodoUseCase
import com.iarosch.simpletodoapp.home.domain.impl.DeleteTodoUseCaseImpl
import com.iarosch.simpletodoapp.home.domain.impl.GetAllTodoUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class HomeScreenModule {

    @Binds
    abstract fun bindDeleteTodoUseCase(
        deleteTodoUseCaseImpl: DeleteTodoUseCaseImpl
    ) : DeleteTodoUseCase

    @Binds
    abstract fun bindGetAllTodosUseCase(
        getAllTodoUseCaseImpl: GetAllTodoUseCaseImpl
    ) : GetAllTodoUseCase
}