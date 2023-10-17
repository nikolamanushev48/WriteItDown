package com.example.notesapp.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.notesapp.R
import com.example.notesapp.data.Note
import com.example.notesapp.ui.components.AppTitle
import com.example.notesapp.ui.components.NoteItem
import com.example.notesapp.utils.EDIT_NOTE_SCREEN_ROUTE
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController
) {
    val coroutineScope = rememberCoroutineScope()
    val notes = remember {
        mutableStateOf<List<Note>>(emptyList())
    }
    var isDeletable by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(Unit) {
        viewModel.noteRepository.getAllNotes()?.first().let {
            if (it != null) {
                notes.value = it.sortedByDescending { note ->
                    note.isPinned
                }
            }
        }
    }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        floatingActionButton = {
            FloatingActionButton(onClick = {
                Note(
                    title = "Enter Title...",
                    content = "Enter Content ..."
                ).let {
                    coroutineScope.launch {
                        viewModel.noteRepository.addNote(it).let { id ->
                            navController.navigate(
                                EDIT_NOTE_SCREEN_ROUTE +
                                        "?noteId=${id}"
                            )
                        }
                    }
                }
            }) {
                Icon(
                    Icons.Default.Add,
                    contentDescription = stringResource(R.string.add)
                )
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { paddingVal ->

        Column(
            modifier = Modifier.padding(paddingVal)
        ) {
            AppTitle(56, 20)
            Spacer(modifier = Modifier.height(20.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                contentPadding = PaddingValues(10.dp),
                userScrollEnabled = true
            ) {
                items(notes.value) { note ->
                    val noteState = remember { mutableStateOf(note) }
                    NoteItem(
                        viewModel = viewModel,
                        coroutineScope = coroutineScope,
                        note = noteState.value,
                        isDeletable = isDeletable,
                        isDeleted = { deletedNote ->
                            notes.value = notes.value.filterNot { it == deletedNote }
                        },
                        isUnpinned = { unpinnedNote ->
                            noteState.value = unpinnedNote
                        },
                        modifier = Modifier
                            .combinedClickable(
                                onLongClick = {
                                    isDeletable = true
                                },
                                onClick = {
                                    navController.navigate(EDIT_NOTE_SCREEN_ROUTE + "?noteId=${note.id}")
                                }
                            )
                    )
                }
            }
        }
    }
}