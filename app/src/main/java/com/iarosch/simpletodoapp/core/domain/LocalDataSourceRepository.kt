package com.iarosch.simpletodoapp.core.domain

import com.iarosch.simpletodoapp.core.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface LocalDataSourceRepository {

    fun getAllTodoFlow(): Flow<List<Todo>>

    fun getTodoByIdFlow(id: Int): Flow<Todo>

    suspend fun addTodo(note: Todo)

    suspend fun updateTodo(note: Todo)

    suspend fun deleteTodo(note: Todo)

}