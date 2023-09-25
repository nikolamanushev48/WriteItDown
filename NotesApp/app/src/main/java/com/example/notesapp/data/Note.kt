package com.example.notesapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey val noteId: Long,
    val title: String,
    val content: String,
    val color: Int
) {

}