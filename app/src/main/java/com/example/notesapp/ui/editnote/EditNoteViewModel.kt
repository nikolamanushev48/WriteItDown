package com.example.notesapp.ui.editnote

import androidx.lifecycle.ViewModel
import com.example.notesapp.domain.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(
    val noteRepository: NoteRepository,
) : ViewModel()