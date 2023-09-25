package com.example.notesapp.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Notes(
    @PrimaryKey val noteId: Long,
    val title: String,
    val content: String,
    val color: Int
) {
}