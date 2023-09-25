package com.example.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    fun getALlNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE noteId = :noteId")
    fun getNote(noteId: Long): Flow<Note>

    @Insert
    fun addNote(note: Note)

    @Delete
    fun deleteNote(note: Note)
}