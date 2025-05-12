package com.iarosch.simpletodoapp.core.data.repository

import com.iarosch.simpletodoapp.core.data.source.local.LocalDataSource
import com.iarosch.simpletodoapp.core.domain.LocalDataSourceRepository
import com.iarosch.simpletodoapp.core.domain.model.Todo
import javax.inject.Inject

class LocalDataSourceRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
) : LocalDataSourceRepository {

    override fun getAllNotesFlow() = localDataSource.getAllNotesFlow()

    override fun getNoteByIdFlow(id: Int) = localDataSource.gelNoteByIdFlow(id)

    override suspend fun updateNote(note: Todo) = localDataSource.updateNote(note)

    override suspend fun addNote(note: Todo) = localDataSource.addNote(note)

    override suspend fun deleteNote(note: Todo) = localDataSource.deleteNote(note)
}