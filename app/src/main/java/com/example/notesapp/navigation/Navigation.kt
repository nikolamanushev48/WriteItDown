package com.example.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.notesapp.ui.editnote.EditNoteScreen
import com.example.notesapp.ui.home.HomeScreen

@Composable
fun Navigation(navController: NavHostController) {
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
                    defaultValue = -1L
                }
            )
        ) {
            it.arguments?.getLong("noteId")?.let { id ->
                EditNoteScreen(
                    navController = navController,
                    noteId = id
                )
            }
        }
    }
}