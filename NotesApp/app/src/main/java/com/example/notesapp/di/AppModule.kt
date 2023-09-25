package com.example.notesapp.di

import android.app.Application
import androidx.room.Room
import com.example.notesapp.data.AppDatabase
import com.example.notesapp.data.NoteDao
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
    @Singleton
    fun provideNoteDatabase(app: Application) = Room.databaseBuilder(
        app,
        AppDatabase::class.java,
        AppDatabase.DB_NAME
    ).build()

    @Provides
    @Singleton
    fun provideNotesRepository(noteDao: NoteDao) = NoteRepository(noteDao)
}