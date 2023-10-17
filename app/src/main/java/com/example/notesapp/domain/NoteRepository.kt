package com.example.notesapp.domain

import com.example.notesapp.data.Note
import com.example.notesapp.data.NoteDao
import com.example.notesapp.data.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) : NoteRepository {
    override fun getAllNotes(): Flow<List<Note>>? = noteDao.getAllNotes()

    override suspend fun getNote(noteId: Long): Note? = noteDao.getNote(noteId)

    override suspend fun addNote(note: Note): Long = noteDao.addNote(note)

    override suspend fun clear() = noteDao.clear()
    override suspend fun updateNote(newNote: Note) = noteDao.updateNote(newNote)

    override suspend fun getCurrentNote(): Note? = noteDao.getCurrentNote()

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
}