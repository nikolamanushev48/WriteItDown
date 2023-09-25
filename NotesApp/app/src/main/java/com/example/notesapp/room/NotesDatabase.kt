package com.example.notesapp.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Notes::class], version = 1,)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}