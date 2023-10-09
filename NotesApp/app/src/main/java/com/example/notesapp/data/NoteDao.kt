package com.example.notesapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): Flow<List<Note>>?

    @Query("SELECT * FROM note_table WHERE note_id = :noteId")
    suspend fun getNote(noteId: Long): Note?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: Note) : Long

    @Query("DELETE FROM note_table")
    suspend fun clear()

    @Update
    suspend fun updateNote(newNote: Note)

    @Query("SELECT * FROM note_table ORDER BY note_id DESC LIMIT 1")
    suspend fun getCurrentNote(): Note?

    @Delete
    suspend fun deleteNote(note: Note)
}