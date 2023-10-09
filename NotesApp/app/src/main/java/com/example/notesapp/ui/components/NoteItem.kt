package com.example.notesapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.R
import com.example.notesapp.data.Note
import com.example.notesapp.ui.home.HomeViewModel

@Composable
fun NoteItem(
    viewModel: HomeViewModel,
    note: Note,
    modifier: Modifier,
) {
    Card(
        modifier = modifier
            .padding(5.dp)
            .size(180.dp, 180.dp),
        shape = RoundedCornerShape(15.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.Black
        )
    ) {
        Row {
            Column {
                Text(
                    text = note.title,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 10.dp, bottom = 5.dp)
                )
                Text(
                    text = note.content,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    maxLines = 8,
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.trash_bin_icon),
                contentDescription = stringResource(R.string.delete_note),
                tint = Color.White,
                modifier = Modifier
                    .padding(start = 12.dp, top = 8.dp)
                    .clickable {
                        viewModel.deleteNote(note)
                    }
            )
        }
    }
}