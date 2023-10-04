package com.example.notesapp.domain.editnote

import com.example.notesapp.utils.EMPTY_STRING

data class EditNoteUIModel(
    val title: String = EMPTY_STRING,
    val content: String = EMPTY_STRING
)