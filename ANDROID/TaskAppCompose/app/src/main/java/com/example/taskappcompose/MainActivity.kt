package com.example.taskappcompose

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.taskappcompose.layouts.products.ProductListActivity
import com.example.taskappcompose.layouts.tasks.TasksListActivity
import com.example.taskappcompose.layouts.tasks.TasksListPreview
import com.example.taskappcompose.ui.theme.Background
import com.example.taskappcompose.ui.theme.Primary
import com.example.taskappcompose.ui.theme.TaskAppComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val intentProduct = Intent(this, ProductListActivity::class.java)
        val intentTask = Intent(this, TasksListActivity::class.java)
        setContent {
            TaskAppComposeTheme {
                MainMenu(
                    list = listOf(
                        MenuModalView("Menu 1", onButtonClick = {startActivity(intentProduct)}),
                        MenuModalView("Menu 1", onButtonClick = {startActivity(intentTask)})
                    )
                )
            }
        }
    }
}

@Composable
private fun MainMenu(list: List<MenuModalView>, modifier: Modifier = Modifier){
    Card(
        modifier = modifier
            .padding(16.dp)
            .background(Background),
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            list.forEach { (buttonText, onClick) ->
                Button(
                    onClick = onClick,
                    colors = buttonColors(
                        containerColor = Primary,
                        contentColor = Color.White
                    ),
                ) {
                    Text(
                        text = buttonText,
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true, device = "id:pixel", apiLevel = 34)
@Composable
fun MainPreview() {

    TaskAppComposeTheme {
        MainMenu(
            list = listOf(
                MenuModalView("Menu 1", onButtonClick = {}),
                MenuModalView("Menu 1", onButtonClick = {}))
            )
    }
}
