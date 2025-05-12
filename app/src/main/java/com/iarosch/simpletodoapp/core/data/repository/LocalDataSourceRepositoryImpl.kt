package com.iarosch.simpletodoapp.core.data.repository

import com.iarosch.simpletodoapp.core.data.source.local.LocalDataSource
import com.iarosch.simpletodoapp.core.domain.LocalDataSourceRepository
import com.iarosch.simpletodoapp.core.domain.model.Todo
import javax.inject.Inject

class LocalDataSourceRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
) : LocalDataSourceRepository {

    override fun getAllTodoFlow() = localDataSource.getAllNotesFlow()

    override fun getTodoByIdFlow(id: Int) = localDataSource.gelNoteByIdFlow(id)

    override suspend fun updateTodo(note: Todo) = localDataSource.updateNote(note)

    override suspend fun addTodo(note: Todo) = localDataSource.addNote(note)

    override suspend fun deleteTodo(note: Todo) = localDataSource.deleteNote(note)
}