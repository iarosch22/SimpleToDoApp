package com.iarosch.simpletodoapp.core.data.mapper

import com.iarosch.simpletodoapp.core.data.source.local.model.TodoEntity
import com.iarosch.simpletodoapp.core.domain.model.Todo

fun TodoEntity.toNote() = Todo(id, title, description)
fun Todo.toNoteEntity() = TodoEntity(id, title, description)