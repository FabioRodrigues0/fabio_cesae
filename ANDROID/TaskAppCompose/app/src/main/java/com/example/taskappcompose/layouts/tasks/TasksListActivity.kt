package com.example.taskappcompose.layouts.tasks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskappcompose.InputForm
import com.example.taskappcompose.components.AppTitle
import com.example.taskappcompose.components.BackButton
import com.example.taskappcompose.components.ItemsList
import com.example.taskappcompose.components.MenuCard
import com.example.taskappcompose.ui.theme.GreenMuted
import com.example.taskappcompose.ui.theme.Primary
import com.example.taskappcompose.ui.theme.RedMuted
import com.example.taskappcompose.ui.theme.TaskAppComposeTheme
import kotlinx.coroutines.launch
import androidx.compose.material3.Button
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import com.example.taskappcompose.ui.theme.Background
import kotlinx.coroutines.CoroutineScope

class TasksListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val itemsList = remember { mutableStateListOf("") }
            var showBottomSheet by remember { mutableStateOf(false) }
            val onChangeBottomSheet = { showBottomSheet = !showBottomSheet }

            val scope = rememberCoroutineScope()

            TaskAppComposeTheme {
                Scaffold(
                    topBar = { AppTitle(textLabel = "Lista de Tarefas", modifier = Modifier) },
                    bottomBar = { BackButton(finish = { finish() }) },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                showBottomSheet = true
                            }
                        ){
                            Icon(
                                Icons.Filled.KeyboardArrowUp,
                                contentDescription = "Open"
                            )
                        }
                    },
                    containerColor = Primary,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp),
                ) { innerPadding ->
                    ContentTasks(
                        itemsList,
                        innerPadding,
                        showBottomSheet,
                        onChangeBottomSheet,
                        scope
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ContentTasks(
    itemsList: SnapshotStateList<String>,
    innerPadding: PaddingValues,
    showBottomSheet: Boolean = false,
    onChangeBottomSheet: () -> Unit,
    scope: CoroutineScope
) {
    val sheetState = rememberModalBottomSheetState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp)
            .background(color = Primary, shape = RectangleShape)
    ) {
        if (showBottomSheet) {
            ModalBottomSheet(
                containerColor = Background,
                onDismissRequest = {
                    onChangeBottomSheet.invoke()
                },
                sheetState = sheetState
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    // Sheet content
                    Button(onClick = {
                        scope.launch { sheetState.hide() }.invokeOnCompletion {
                            if (!sheetState.isVisible) {
                                onChangeBottomSheet.invoke()
                            }
                        }
                    }) {
                        Icon(Icons.Filled.KeyboardArrowDown, contentDescription = "Close")
                    }
                    MenuCard(
                        arrayInputs = arrayOf(
                            InputForm(
                                "Nome da Tarefa",
                                "Adicionar Tarefa",
                                "Adicionar",
                                GreenMuted,
                                itemsList
                            ),
                            InputForm(
                                "Nome da Tarefa",
                                "Remover Tarefa",
                                "Remover",
                                RedMuted,
                                itemsList
                            )
                        ),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
        ItemsList(
            itemsList = itemsList,
            modifier = Modifier.padding(2.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TasksListPreview() {
    var showBottomSheetTemp by remember { mutableStateOf(false) }
    val onChangeBottomSheetTemp = { showBottomSheetTemp = !showBottomSheetTemp }
    val scopeTemp = rememberCoroutineScope()

    TaskAppComposeTheme {
        ContentTasks(
            itemsList = SnapshotStateList<String>().apply {
                add("Item 1")
                add("Item 2")
                add("Item 3")
            },
            innerPadding = PaddingValues(10.dp),
            showBottomSheet = showBottomSheetTemp,
            onChangeBottomSheet = onChangeBottomSheetTemp,
            scope = scopeTemp
        )
    }
}