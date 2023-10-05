package com.example.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notesapp.ui.NotesScreen
import com.example.notesapp.ui.editnote.EditNoteScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.NotesScreen.route) {
        composable(route = Screen.NotesScreen.route) {
            NotesScreen(navController = navController)
        }
        composable(
            route = Screen.EditNoteScreen.route,
            arguments = listOf(
                navArgument(
                    name = "noteId"
                ) {
                    type = NavType.LongType
                    defaultValue = -1
                }
            )
        ) {
            EditNoteScreen(
                navController = navController,
                noteId = it.arguments?.getLong("noteId") ?: -1L
            )
        }
    }
}