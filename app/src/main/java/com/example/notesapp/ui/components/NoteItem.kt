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
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.R
import com.example.notesapp.data.Note
import com.example.notesapp.ui.home.HomeViewModel
import com.google.android.play.integrity.internal.f
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun NoteItem(
    viewModel: HomeViewModel,
    coroutineScope: CoroutineScope,
    note: Note,
    modifier: Modifier,
    isDeletable: Boolean,
    isDeleted: (Note) -> Unit,
    isUnpinned: (Note) -> Unit
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
        Surface(
            shape = RectangleShape,
            color = Color.Black
        ) {

            Column {
                Text(
                    text = note.title,
                    color = Color.White,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(
                        start = 10.dp,
                        bottom = 5.dp,
                        end = 30.dp
                    ),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = note.content,
                    color = Color.Gray,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(start = 10.dp),
                    maxLines = 8,
                )
            }


            if (isDeletable) {
                Icon(
                    painter = painterResource(id = R.drawable.trash_bin_icon),
                    contentDescription = stringResource(R.string.delete_note),
                    tint = Color.White,
                    modifier = Modifier
                        .padding(start = 146.dp, top = 8.dp)
                        .clickable {
                            coroutineScope.launch {
                                viewModel.noteRepository.deleteNote(note)
                                isDeleted.invoke(note)
                            }
                        }
                )
            }


            if (note.isPinned) {
                Icon(
                    painter = painterResource(id = R.drawable.pin_icon),
                    contentDescription = stringResource(R.string.pin_to_home),
                    tint = Color.White,
                    modifier = Modifier
                        .padding(start = 140.dp, top = 140.dp)
                        .clickable {
                            coroutineScope.launch {
                                note
                                    .copy(isPinned = false)
                                    .let {
                                        viewModel.noteRepository.updateNote(it)
                                        isUnpinned.invoke(it)
                                    }
                            }
                        }
                )
            }
        }
    }
}