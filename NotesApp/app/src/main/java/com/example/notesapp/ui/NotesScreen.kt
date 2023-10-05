package com.example.notesapp.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.notesapp.data.Note
import com.example.notesapp.ui.components.AppTitle
import com.example.notesapp.ui.components.NoteItem
import com.example.notesapp.utils.EDIT_NOTE_SCREEN_ROUTE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotesScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {

            }) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingVal ->
        Column(modifier = Modifier.padding(paddingVal)) {
            AppTitle(56, 20)
            Spacer(modifier = Modifier.height(20.dp))
            NoteItem(
                note = Note(1, "Title", "Hey this is my new note"),
                modifier = Modifier.clickable {
                    navController.navigate(EDIT_NOTE_SCREEN_ROUTE)
                }
            )
        }
    }
}