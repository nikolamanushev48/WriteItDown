package com.example.notesapp.domain

import com.example.notesapp.data.Note
import com.example.notesapp.data.NoteDao
import com.example.notesapp.data.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>> = noteDao.getALlNotes()

    override fun getNote(noteId: Long): Flow<Note> = noteDao.getNote(noteId)

    override fun addNote(note: Note) = noteDao.addNote(note)

    override fun deleteNote(note: Note) = noteDao.deleteNote(note)
}