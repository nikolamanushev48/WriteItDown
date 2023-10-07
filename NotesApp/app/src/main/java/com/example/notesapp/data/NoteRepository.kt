package com.example.notesapp.data

interface NoteRepository {
     suspend fun getAllNotes(): List<Note>?
     suspend fun getNote(noteId: Long): Note
     suspend fun addNote(note: Note)
     suspend fun clear()

     suspend fun updateNote(newNote: Note)
     suspend fun getCurrentNote(): Note?
     suspend fun deleteNote(note: Note)
}