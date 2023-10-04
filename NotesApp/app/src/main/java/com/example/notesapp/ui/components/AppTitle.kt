package com.example.notesapp.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.notesapp.R

@Composable
fun AppTitle() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.padding(start = 20.dp)
    ) {
        Icon(
            painter = painterResource(id = R.drawable.pen_icon),
            contentDescription = stringResource(
                R.string.pen_icon
            ),
            tint = MaterialTheme.colorScheme.primary
        )

        Text(
            stringResource(R.string.write_it_down),
            textAlign = TextAlign.Center,
            fontSize = 56.sp,
            fontFamily = FontFamily.Cursive,
            color = MaterialTheme.colorScheme.primary
        )
    }
}