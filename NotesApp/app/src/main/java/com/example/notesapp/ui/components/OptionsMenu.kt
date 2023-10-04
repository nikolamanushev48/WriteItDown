package com.example.notesapp.ui.components

import android.widget.Toast
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.example.notesapp.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OptionMenu() {

    var showMenu by remember { mutableStateOf(false) }
    val context = LocalContext.current

    TopAppBar(
        colors = TopAppBarDefaults.smallTopAppBarColors(
            containerColor = MaterialTheme.colorScheme.tertiary,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                stringResource(R.string.write_it_down),
                textAlign = TextAlign.Center
            )
        },
        navigationIcon = {
            Icon(
                painter = painterResource(id = R.drawable.pen_icon),
                contentDescription = stringResource(
                    R.string.pen_icon
                )
            )
        },
        actions = {

            IconButton(onClick = {
                Toast.makeText(context, "Favorite", Toast.LENGTH_SHORT).show()
            }) {
                Icon(Icons.Default.Favorite, "")
            }

            IconButton(onClick = { showMenu = !showMenu }) {
                Icon(Icons.Default.MoreVert, "")
            }

            DropdownMenu(
                expanded = showMenu,
                onDismissRequest = { showMenu = false }
            ) {

                DropdownMenuItem(onClick = {
                    Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show()
                },text = {
                    Text(text = "Settings")
                })

                DropdownMenuItem(onClick = {
                    Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                },text = {
                    Text(text = "Logout")
                })

            }


        }
    )
}