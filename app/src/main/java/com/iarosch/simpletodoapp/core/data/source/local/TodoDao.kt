package com.iarosch.simpletodoapp.core.data.source.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.iarosch.simpletodoapp.core.data.source.local.model.TodoEntity
import kotlinx.coroutines.flow.Flow

interface TodoDao {

    @Query("SELECT * FROM todoEntity")
    fun getAllTodo() : Flow<List<TodoEntity>>
    @Insert
    fun insertTodo(todo: TodoEntity)
    @Update
    fun updateTodo(todo: TodoEntity)
    @Query("SELECT * FROM todoEntity WHERE id=:id")
    fun getTodoById(id: Int) : Flow<TodoEntity>
    @Delete
    fun delete(todo: TodoEntity)

}