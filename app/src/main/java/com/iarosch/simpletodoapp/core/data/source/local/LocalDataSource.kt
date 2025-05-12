package com.iarosch.simpletodoapp.core.data.source.local

import com.iarosch.simpletodoapp.core.domain.model.Todo
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getAllNotesFlow(): Flow<List<Todo>>

    fun gelNoteByIdFlow(id: Int): Flow<Todo>

    suspend fun addNote(note: Todo)

    suspend fun updateNote(note: Todo)

    suspend fun deleteNote(note: Todo)

}