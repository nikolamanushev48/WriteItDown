package com.example.notesapp.ui.editnote

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.notesapp.ui.components.OptionMenu

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNoteScreen(
    //viewModel: EditNoteViewModel = hiltViewModel(),
    title: String
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = MaterialTheme.colorScheme.background,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {

                },
                containerColor = MaterialTheme.colorScheme.background
            ) {
                Icon(
                    Icons.Default.Check, contentDescription = "Check",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        },
        topBar = { OptionMenu() }
    ) { paddingVal ->
        var noteContent by remember { mutableStateOf("") }

        Column(
            Modifier.padding(paddingVal),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                fontSize = 30.sp,
                maxLines = 1
            )
            TextField(
                value = noteContent,
                onValueChange = { noteContent = it },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.6f),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    textColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}