package com.iarosch.simpletodoapp.core.data.source.local.di

import android.content.Context
import androidx.room.Room
import com.iarosch.simpletodoapp.core.data.repository.LocalDataSourceRepositoryImpl
import com.iarosch.simpletodoapp.core.data.source.local.LocalDataSource
import com.iarosch.simpletodoapp.core.data.source.local.RoomLocalDataSource
import com.iarosch.simpletodoapp.core.data.source.local.db.TodoRoomDatabase
import com.iarosch.simpletodoapp.core.domain.LocalDataSourceRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalSourceModuleProvider {

    @Provides
    fun provideNoteDao(database: TodoRoomDatabase) = database.todoDao()

    @Provides
    @Singleton
    fun providesLocalDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        TodoRoomDatabase::class.java,
        "todo-database"
    ).build()
}

@Module
@InstallIn(SingletonComponent::class)
abstract class LocalSourceModuleBinder {

    @Binds
    abstract fun bindRoomLocalDataSource(
        roomLocalDataSource: RoomLocalDataSource
    ) : LocalDataSource

    @Binds
    abstract fun bindDefaultJustNotesRepository(
        defaultJustNotesRepository: LocalDataSourceRepositoryImpl
    ) : LocalDataSourceRepository
}