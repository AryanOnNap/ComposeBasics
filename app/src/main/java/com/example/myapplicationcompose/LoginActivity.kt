package com.example.myapplicationcompose

import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, ) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationComposeTheme {
Surface(color = MaterialTheme.colors.background) {

    
}
            }
        }
    }
}
    @Composable
    public fun LogIn(){
        var userName = remember {
            mutableStateOf("") }
        var password = remember {
            mutableStateOf("")
        }
        Column {
            Text(text = "Welcome to Login",fontSize = 20.sp,fontWeight = FontWeight.Bold,
            color = Color.Black, fontFamily = FontFamily.Monospace )
            OutlinedTextField(value = userName.value , onValueChange ={

            } ,
                leadingIcon ={
                    Icon(Icons.Default.Person, contentDescription = "username")
                },
                label ={Text(text = "Username")},
                placeholder = {
                    Text(text = "Enter Username")
                }
            )
            OutlinedTextField(value = password.value , onValueChange ={

            } ,
                leadingIcon ={
                    Icon(Icons.Default.Lock, contentDescription = "Password")
                },
                label ={Text(text = "Password")},
                placeholder = {
                    Text(text = "Enter password")
                }
            )
            
        }
    }
@Preview( uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode")
@Composable
fun PreviewLogin(){
    Surface(color = MaterialTheme.colors.background) {

LogIn()
    }

}
