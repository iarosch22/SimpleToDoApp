package com.iarosch.simpletodoapp.core.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TodoEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    @ColumnInfo val title: String,
    @ColumnInfo val description: String
)