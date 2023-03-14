package com.example.myapplicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class TodoActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MyApplicationComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AddToolBar()
                }
            }
        }
    }

    @Composable
    private fun AddToolBar() {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "TodoLList App")
                    }
                )


            },
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ) {
        }


    }
}