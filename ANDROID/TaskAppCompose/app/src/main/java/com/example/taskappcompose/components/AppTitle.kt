package com.example.taskappcompose.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.taskappcompose.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTitle(textLabel: String, modifier: Modifier = Modifier) {
    TopAppBar(
        colors = topAppBarColors(
            containerColor = Primary,
            titleContentColor = Color.White,
        ),
        title = {
            Text(text = textLabel)
        })
}