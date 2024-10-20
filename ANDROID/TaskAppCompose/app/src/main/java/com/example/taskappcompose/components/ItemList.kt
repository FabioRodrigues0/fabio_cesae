package com.example.taskappcompose.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import com.example.taskappcompose.ui.theme.Background
import com.example.taskappcompose.ui.theme.Foreground

@Composable
fun ItemsList(modifier: Modifier = Modifier, itemsList: SnapshotStateList<String>) {
    if (itemsList.size > 1 || itemsList[0].isNotBlank()) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Background),
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp)
        ) {
            LazyColumn (
                modifier = modifier
                    .fillMaxWidth()
                    .padding(start = 15.dp, end = 15.dp, top = 5.dp, bottom = 5.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp)) {
                items(itemsList.size) { index ->
                    Text(
                        color = Foreground,
                        text = itemsList[index],
                        style = TextStyle(fontSize = TextUnit(20f, type = TextUnitType.Sp)),
                        modifier = Modifier.padding(5.dp)
                    )
                    HorizontalDivider()
                }
            }
        }
    }}

@Preview(showBackground = true)
@Composable
private fun ItemsListPreview() {
    ItemsList(itemsList = SnapshotStateList<String>().apply {
        add("Item 1")
        add("Item 2")
        add("Item 3")
    })
    }
