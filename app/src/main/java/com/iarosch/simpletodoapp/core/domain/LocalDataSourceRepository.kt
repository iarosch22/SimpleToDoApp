package com.iarosch.simpletodoapp.core.domain

import com.iarosch.simpletodoapp.core.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface LocalDataSourceRepository {

    fun getAllNotesFlow(): Flow<List<Todo>>

    fun getNoteByIdFlow(id: Int): Flow<Todo>

    suspend fun addNote(note: Todo)

    suspend fun updateNote(note: Todo)

    suspend fun deleteNote(note: Todo)

}