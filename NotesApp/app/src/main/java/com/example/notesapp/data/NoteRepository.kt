package com.example.notesapp.data

import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun getAllNotes(): Flow<List<Note>>
    suspend fun getNote(noteId: Long): Flow<Note>
    suspend fun addNote(note: Note)
    suspend fun clear()
    suspend fun getCurrentNote(): Note?
    suspend fun deleteNote(note: Note)
}