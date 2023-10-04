package com.example.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notesapp.ui.editnote.EditNoteScreen
import com.example.notesapp.ui.NotesScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.NotesScreen.route) {
        composable(route = Screen.NotesScreen.route) {
            NotesScreen(navController = navController)
        }
        composable(route = Screen.EditNoteScreen.route,
            arguments = listOf(navArgument("name") {
                type = NavType.StringType
                defaultValue = "Nikola"
                nullable = true
            }
            )
        ) { entry ->
            entry.arguments?.getString("name")?.let { EditNoteScreen(title = it) }
        }
    }
}