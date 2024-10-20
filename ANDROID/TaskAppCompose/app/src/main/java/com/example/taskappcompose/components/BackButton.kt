package com.example.taskappcompose.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.example.taskappcompose.ui.theme.Primary

@Composable
fun BackButton(finish: () -> Unit) {
    BottomAppBar (
        containerColor = Primary,
        contentPadding = PaddingValues(start = 10.dp, end = 10.dp)
    ) {
        OutlinedButton(
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Primary),
            border = BorderStroke(1.dp, Color.White),
            onClick = finish
        ) {
            Text(text = "Voltar", style = TextStyle(color = Color.White))
        }
    }
}