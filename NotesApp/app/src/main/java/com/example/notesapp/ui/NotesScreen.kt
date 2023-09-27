package com.example.notesapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.notesapp.R
import com.example.notesapp.data.Note
import com.example.notesapp.ui.components.NoteItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen() {

    Scaffold(
        modifier = Modifier.padding(10.dp),
        floatingActionButton = {
            FloatingActionButton(onClick = {

            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = {
                    Text(
                        stringResource(R.string.write_it_down),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.pen_icon),
                        contentDescription = stringResource(
                            R.string.pen_icon
                        )
                    )
                }
            )
        },
    ) { paddingVal ->
        Column(modifier = Modifier.padding(paddingVal)) {

            NoteItem(
                note = Note(1, "Title", "Hey this is my new note", 12),
                modifier = Modifier.clickable {

                }
            )
        }
    }
}