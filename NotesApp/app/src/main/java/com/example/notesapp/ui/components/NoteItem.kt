package com.example.notesapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.data.Note

@Composable
fun NoteItem(
    note: Note,
    modifier: Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(start = 10.dp, end = 10.dp)
            .wrapContentHeight(),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Column(modifier = Modifier) {
            Text(
                text = note.title,
                color = Color.White,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
            Text(
                text = note.content,
                color = Color.White,
                fontSize = 15.sp,
                modifier = Modifier.padding(start = 10.dp),
                maxLines = 8
            )
        }
    }
}