package com.example.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.notesapp.ui.editnote.EditNoteScreen
import com.example.notesapp.ui.home.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.EditNoteScreen.route + "?noteId={noteId}",
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
                noteId = 2L//it.arguments?.getLong("noteId") ?: -1L
            )
        }
    }
}