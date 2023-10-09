package com.example.notesapp.data

import kotlinx.coroutines.flow.Flow

interface NoteRepository {
     fun getAllNotes(): Flow<List<Note>>?
     suspend fun getNote(noteId: Long): Note?
     suspend fun addNote(note: Note): Long
     suspend fun clear()

     suspend fun updateNote(newNote: Note)
     suspend fun getCurrentNote(): Note?
     suspend fun deleteNote(note: Note)
}