package com.example.notesapp.ui.editnote

import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.notesapp.R
import com.example.notesapp.domain.editnote.EditNoteUIModel
import com.example.notesapp.utils.NOTES_SCREEN_ROUTE

class EditNoteViewModel : ViewModel() {
    val uiData: LiveData<EditNoteUIModel>
        get() = _uiData

    private val _uiData = MutableLiveData(EditNoteUIModel())

    private val _navigateToHome = MutableLiveData<String>()
    val navigateToHome: LiveData<String> = _navigateToHome

//    fun menuItemSelected(menuItem: MenuItem): Boolean =
//        when (menuItem.itemId) {
//            R.id.pin_to_home -> {
//                _navigateToHome.value = NOTES_SCREEN_ROUTE
//                true
//            }
//            R.id.delete -> {
//
//                true
//            }
//            else -> false
//        }
}