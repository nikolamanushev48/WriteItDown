package com.example.notesapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.notesapp.R
import com.example.notesapp.data.Note
import com.example.notesapp.ui.editnote.EditNoteViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionMenu(
    navController: NavHostController,
    viewModel: EditNoteViewModel,
    currentNote: MutableState<Note>,
    noteTitle: MutableState<String>,
    noteContent: MutableState<String>
) {
    val coroutineScope = rememberCoroutineScope()
    var showMenu by remember { mutableStateOf(false) }
    var favouriteNote by remember { mutableStateOf(false) }

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = Color.Transparent,
            titleContentColor = MaterialTheme.colorScheme.primary,
            navigationIconContentColor = MaterialTheme.colorScheme.primary,
            actionIconContentColor = MaterialTheme.colorScheme.primary
        ),
        title = {
            AppTitle(textSize = 34, paddingStart = 10)
        },
        navigationIcon = {
            IconButton(onClick = {
                coroutineScope.launch {
                    viewModel.noteRepository.updateNote(
                        Note(
                            currentNote.value.id,
                            noteTitle.value,
                            noteContent.value,
                            currentNote.value.isPinned
                        )
                    )
                }
                navController.popBackStack()
            }) {
                Icon(Icons.Default.ArrowBack, "")
            }
        },
        actions = {
            IconButton(onClick = { favouriteNote = !favouriteNote }) {
                if (favouriteNote) {
                    Icon(
                        Icons.Default.Favorite, "",
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(36.dp, 36.dp)
                    )
                } else {
                    Icon(
                        Icons.Default.Favorite, "",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(36.dp, 36.dp)
                    )
                }
            }

            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(
                    Icons.Default.MoreVert,
                    "",
                )
            }

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false },
                modifier = Modifier.background(Color.Black)
            ) {

                DropdownMenuItem(onClick = {
                    coroutineScope.launch {
                        viewModel.noteRepository.updateNote(
                            Note(
                                currentNote.value.id,
                                noteTitle.value,
                                noteContent.value,
                                true
                            )
                        )
                        showMenu = false
                        navController.popBackStack()
                    }
                },
                    colors = MenuDefaults.itemColors(
                        textColor = MaterialTheme.colorScheme.primary
                    ), text = {
                        Text(text = stringResource(id = R.string.pin_to_home))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.pin_icon),
                            contentDescription = stringResource(
                                R.string.pen_icon
                            ),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    })

                DropdownMenuItem(onClick = {
                    coroutineScope.launch {
                        viewModel.noteRepository.deleteNote(currentNote.value)
                        showMenu = false
                        navController.popBackStack()
                    }
                },
                    colors = MenuDefaults.itemColors(
                        textColor = MaterialTheme.colorScheme.primary
                    ), text = {
                        Text(text = stringResource(id = R.string.delete))
                    },
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.trash_bin_icon),
                            contentDescription = stringResource(
                                R.string.pen_icon
                            ),
                            tint = MaterialTheme.colorScheme.primary
                        )
                    })
            }
        }
    )
}