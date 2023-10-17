package com.example.notesapp.di

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.notesapp.data.NoteDao
import com.example.notesapp.data.NotesDatabase
import com.example.notesapp.domain.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideContext(application: Application): Context = application

    @Provides
    @Singleton
    fun provideNoteDatabase( application: Application) : NotesDatabase = Room.databaseBuilder(
        application.applicationContext,
        NotesDatabase::class.java,
        NotesDatabase.DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideNotesRepository(noteDao: NoteDao) = NoteRepository(noteDao)

    @Singleton
    @Provides
    fun providesNotesDao(database: NotesDatabase) = database.noteDao()
}