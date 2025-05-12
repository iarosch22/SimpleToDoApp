package com.iarosch.simpletodoapp.create_and_update.domain.di

import com.iarosch.simpletodoapp.create_and_update.domain.AddTodoUseCase
import com.iarosch.simpletodoapp.create_and_update.domain.GetTodoByIdUseCase
import com.iarosch.simpletodoapp.create_and_update.domain.UpdateTodoUseCase
import com.iarosch.simpletodoapp.create_and_update.domain.impl.AddTodoUseCaseImpl
import com.iarosch.simpletodoapp.create_and_update.domain.impl.GetTodoByIdUseCaseImpl
import com.iarosch.simpletodoapp.create_and_update.domain.impl.UpdateTodoUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CreateUpdateDomainModule {

    @Binds
    abstract fun bindAddTodoUseCase(
        addTodoUseCaseImpl: AddTodoUseCaseImpl
    ): AddTodoUseCase

    @Binds
    abstract fun bindGetTodoByIdUseCase(
        getTodoByIdUseCaseImpl: GetTodoByIdUseCaseImpl
    ): GetTodoByIdUseCase

    @Binds
    abstract fun bindUpdateTodoUseCase(
        updateTodoUseCaseImpl: UpdateTodoUseCaseImpl
    ): UpdateTodoUseCase

}