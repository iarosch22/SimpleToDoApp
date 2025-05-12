package com.iarosch.simpletodoapp.core.data.source.local.db

import androidx.room.Database
import com.iarosch.simpletodoapp.core.data.source.local.TodoDao
import com.iarosch.simpletodoapp.core.data.source.local.model.TodoEntity

@Database(entities = [TodoEntity::class], version = 1)
abstract class TodoRoomDatabase {

    abstract fun todoDao() : TodoDao

}