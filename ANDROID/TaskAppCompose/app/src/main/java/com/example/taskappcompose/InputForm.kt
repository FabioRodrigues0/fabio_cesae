package com.example.taskappcompose

import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.graphics.Color

class InputForm(
    labelParam: String,
    placeholderParam: String,
    descriptionParam: String,
    colorParam: Color,
    itemsList: SnapshotStateList<String>
) {
    val label = labelParam
    val placeholder = placeholderParam
    val description = descriptionParam
    val color = colorParam
    val items = itemsList
}