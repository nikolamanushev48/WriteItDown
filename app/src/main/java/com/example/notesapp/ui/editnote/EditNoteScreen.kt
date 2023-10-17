package com.example.notesapp.ui.editnote

import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notesapp.data.Note
import com.example.notesapp.ui.components.OptionMenu
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNoteScreen(
    viewModel: EditNoteViewModel = hiltViewModel(),
    navController: NavHostController,
    noteId: Long
) {
    val coroutineScope = rememberCoroutineScope()
    val scrollState = rememberScrollState()
    val noteTitle = remember { mutableStateOf("") }
    val noteContent = remember { mutableStateOf("") }
    val currentNoteState = remember { mutableStateOf(Note()) }
    LaunchedEffect(Unit) {
        viewModel.noteRepository.getNote(noteId)?.let { note ->
            noteTitle.value = note.title
            noteContent.value = note.content
            currentNoteState.value = note
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    coroutineScope.launch {
                        viewModel.noteRepository.updateNote(
                            Note(
                                id = noteId,
                                title = noteTitle.value,
                                content = noteContent.value,
                                isPinned = currentNoteState.value.isPinned
                            )
                        )
                    }
                    navController.popBackStack()
                },
                containerColor = MaterialTheme.colorScheme.background
            ) {
                Icon(
                    Icons.Default.Check, contentDescription = "Check",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        topBar = {
            OptionMenu(
                navController,
                viewModel,
                currentNoteState,
                noteTitle,
                noteContent
            )
        }
    ) { paddingVal ->
        Column(
            Modifier.padding(paddingVal),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            TextField(
                value = noteTitle.value,
                onValueChange = { noteTitle.value = it },
                modifier = Modifier
                    .padding(start = 20.dp)
                    .wrapContentSize(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    textColor = MaterialTheme.colorScheme.primary,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    disabledPlaceholderColor = Color.Transparent,
                    placeholderColor = Color.Transparent
                ),
                maxLines = 1,
                textStyle = TextStyle(fontSize = 30.sp)
            )

            TextField(
                value = noteContent.value,
                onValueChange = { noteContent.value = it },
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
                    .fillMaxWidth()
                    .fillMaxHeight(0.9f)
                    .border(1.dp, Color.White)
                    .horizontalScroll(
                        scrollState,
                        reverseScrolling = true
                    ),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    textColor = MaterialTheme.colorScheme.primary
                ),
            )
        }
    }
}