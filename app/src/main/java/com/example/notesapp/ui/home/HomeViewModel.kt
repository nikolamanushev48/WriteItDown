package com.example.notesapp.ui.home

import androidx.lifecycle.ViewModel
import com.example.notesapp.domain.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    val noteRepository: NoteRepository,
) : ViewModel()