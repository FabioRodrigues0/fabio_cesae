package com.example.taskappcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.taskappcompose.InputForm
import com.example.taskappcompose.ui.theme.Background
import com.example.taskappcompose.ui.theme.GreenMuted
import kotlinx.coroutines.launch

@Composable
fun MenuCard(arrayInputs: Array<InputForm?>, modifier: Modifier = Modifier) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Background),
        modifier = Modifier
            .size(width = 340.dp, height = 150.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(4.dp)) {
            for (input in arrayInputs) {
                if (input != null) {
                    TextFieldWithIcons(
                        input.label,
                        input.placeholder,
                        input.description,
                        input.color,
                        input.items
                    )
                }
            }
        }
    }
}

@Composable
private fun TextFieldWithIcons(
    label: String, place: String,
    descriptionButton: String, colorButton: Color,
    itemsList: SnapshotStateList<String>,
    modifier: Modifier = Modifier
) {
    val text = remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()

    OutlinedTextField(
        value = text.value,
        onValueChange = { text.value = it },
        label = { Text(label) },
        placeholder = { Text(place) },
        singleLine = true,
        trailingIcon = {
            IconButton(
                onClick = {
                    coroutineScope.launch {
                        if (colorButton == GreenMuted){
                            itemsList.add(text.value.toString())
                        } else {
                            itemsList.remove(text.value.toString())
                        }
                    }
                },
                colors = IconButtonColors(colorButton, Color.Black, Color.Gray, Color.Gray)
            ) {
                Icon(
                    Icons.Filled.PlayArrow,
                    contentDescription = descriptionButton
                )
            }
        },
        modifier = Modifier
            .fillMaxWidth(),
    )
}