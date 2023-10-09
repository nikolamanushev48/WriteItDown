package com.example.notesapp.ui.editnote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapp.data.Note
import com.example.notesapp.domain.NoteRepository
import com.example.notesapp.domain.editnote.EditNoteUIModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNoteViewModel @Inject constructor(
    private val noteRepository: NoteRepository,
) : ViewModel() {
    val uiData: LiveData<EditNoteUIModel>
        get() = _uiData
    private val _uiData = MutableLiveData(EditNoteUIModel())

    suspend fun getNoteById(noteId: Long): Note? = noteRepository.getNote(noteId)


    fun updateNote(newNote: Note) {
        viewModelScope.launch {
            noteRepository.updateNote(newNote)
        }
    }
}