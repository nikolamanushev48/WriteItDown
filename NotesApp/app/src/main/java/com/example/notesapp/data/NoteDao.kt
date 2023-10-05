package com.example.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    suspend fun getALlNotes(): Flow<List<Note>>

    @Query("SELECT * FROM note_table WHERE note_id = :noteId")
    suspend fun getNote(noteId: Long): Flow<Note>

    @Insert
    suspend fun addNote(note: Note)

    @Query("DELETE FROM note_table")
    suspend fun clear()

    @Query("SELECT * FROM note_table ORDER BY note_id DESC LIMIT 1")
    suspend fun getCurrentNote(): Note?

    @Delete
    suspend fun deleteNote(note: Note)
}