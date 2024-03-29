package com.example.notesapp.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notesapp.utils.EMPTY_STRING
import com.example.notesapp.utils.INVALID_ID
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "note_table")
data class Note(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "note_id")
    var id: Long = INVALID_ID,
    var title: String = EMPTY_STRING,
    var content: String = EMPTY_STRING,
    var isPinned: Boolean = false
)