package com.example.notesapp.domain

import com.example.notesapp.data.Note
import com.example.notesapp.data.NoteDao
import com.example.notesapp.data.NoteRepository
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDao: NoteDao) : NoteRepository {
    override suspend fun getAllNotes(): Flow<List<Note>> = noteDao.getALlNotes()

    override suspend fun getNote(noteId: Long): Flow<Note> = noteDao.getNote(noteId)

    override suspend fun addNote(note: Note) = noteDao.addNote(note)

    override suspend fun clear() = noteDao.clear()

    override suspend fun getCurrentNote(): Note? = noteDao.getCurrentNote()

    override suspend fun deleteNote(note: Note) = noteDao.deleteNote(note)
}