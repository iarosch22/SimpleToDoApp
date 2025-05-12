package com.iarosch.simpletodoapp.core.data.source.local

import com.iarosch.simpletodoapp.core.data.mapper.toNote
import com.iarosch.simpletodoapp.core.data.mapper.toNoteEntity
import com.iarosch.simpletodoapp.core.domain.model.Todo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class RoomLocalDataSource @Inject constructor(
    private val todoDao: TodoDao
) : LocalDataSource {


    override fun getAllNotesFlow(): Flow<List<Todo>> {
        return todoDao.getAllTodo().map {
            it.map { todoEntity ->  todoEntity.toNote() }
        }
    }

    override suspend fun addNote(note: Todo) {
        todoDao.insertTodo(note.toNoteEntity())
    }

    override suspend fun deleteNote(note: Todo) {
        todoDao.delete(note.toNoteEntity())
    }

    override suspend fun updateNote(note: Todo) {
        todoDao.updateTodo(note.toNoteEntity())
    }

    override fun gelNoteByIdFlow(id: Int): Flow<Todo> {
        return todoDao.getTodoById(id).map { todoEntity ->
            todoEntity.toNote()
        }
    }
}