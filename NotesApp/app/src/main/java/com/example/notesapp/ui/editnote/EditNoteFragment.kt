package com.example.notesapp.ui.editnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.fragment.findNavController
import com.example.notesapp.R

class EditNoteFragment : Fragment() {

    private val viewModel: EditNoteViewModel by viewModels()
    private val navController by lazy { findNavController() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ComposeView(requireContext()).apply {
        setViewCompositionStrategy(
            ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
        )

        setContent {
            viewModel.uiData.value?.title?.let { EditNoteScreen(it) }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.navigateToHome.observe(viewLifecycleOwner) { route ->
            navController.navigate(route)
        }
    }

//    private fun initializeMenu() {
//        requireActivity().addMenuProvider(object : MenuProvider {
//            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
//                menuInflater.inflate(R.menu.options_menu, menu)
//            }
//
//            override fun onMenuItemSelected(menuItem: MenuItem) =
//                viewModel.menuItemSelected(menuItem)
//        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
//    }

}