package com.example.taskappcompose.layouts.products

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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

class ProductListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val itemsList = remember { mutableStateListOf("") }

            TaskAppComposeTheme {
                Scaffold(
                    topBar = {AppTitle(textLabel = "Lista de Compras", modifier = Modifier) },
                    bottomBar = { BackButton(finish = { finish() }) },
                    containerColor = Primary,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp),
                ) { innerPadding -> ContentProduct(itemsList, innerPadding) }
            }
        }
    }
}

@Composable
private fun ContentProduct(itemsList: SnapshotStateList<String>, innerPadding: PaddingValues) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 90.dp)
            .background(color = Primary, shape = RectangleShape)
    ) {
        MenuCard(
            arrayInputs = arrayOf(
                InputForm(
                    "Nome do Produto",
                    "Adicionar Produto",
                    "Adicionar",
                    GreenMuted,
                    itemsList
                ),
                InputForm(
                    "Nome do Produto",
                    "Remover Produto",
                    "Remover",
                    RedMuted,
                    itemsList
                )
            ),
            modifier = Modifier.padding(innerPadding)
        )
        ItemsList(
            itemsList = itemsList,
            modifier = Modifier.padding(2.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductListPreview() {
    val itemsListTemp = remember {
        mutableStateListOf(
            "Ananás", "Maçã", "Pera"
        )
    }

    TaskAppComposeTheme {
        Scaffold(
            containerColor = Primary,
            contentColor = Color.White,
            bottomBar = { Button(onClick = { }) { Text(text = "Voltar") } },
            modifier = Modifier
                .fillMaxSize()
                .background(color = Primary, shape = RectangleShape)
        ) { innerPadding ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            ) {
                AppTitle(
                    textLabel = "Lista de Compras",
                    modifier = Modifier.padding(innerPadding)
                )
                MenuCard(
                    arrayInputs = arrayOf(
                        InputForm(
                            "Nome do Produto",
                            "Adicionar Produto",
                            "Caixa de texto para adicionar um Produto",
                            GreenMuted,
                            itemsListTemp
                        ),
                        InputForm(
                            "Nome do Produto",
                            "Remover Produto",
                            "Caixa de texto para remnover um Produto",
                            RedMuted,
                            itemsListTemp
                        )
                    ),
                    modifier = Modifier.padding(innerPadding)
                )
                ItemsList(
                    itemsList = itemsListTemp,
                    modifier = Modifier.padding(innerPadding)
                )
            }
        }
    }
}