package com.example.notesapp.data

import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getAllNotes(): Flow<List<Note>>

    fun getNote(noteId: Long): Flow<Note>

    fun addNote(note: Note)

    fun deleteNote(note: Note)
}