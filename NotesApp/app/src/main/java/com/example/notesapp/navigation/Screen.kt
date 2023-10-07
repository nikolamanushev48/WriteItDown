package com.example.notesapp.navigation

import com.example.notesapp.utils.EDIT_NOTE_SCREEN_ROUTE
import com.example.notesapp.utils.NOTES_SCREEN_ROUTE

sealed class Screen(val route: String) {
    object EditNoteScreen: Screen(EDIT_NOTE_SCREEN_ROUTE)
    object HomeScreen: Screen(NOTES_SCREEN_ROUTE)

    fun withArgs(vararg args: String) = buildString {
        append(route)
        args.forEach { arg ->
            append("/$arg")
        }
    }
}