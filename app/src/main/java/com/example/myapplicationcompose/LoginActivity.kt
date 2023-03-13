package com.example.myapplicationcompose

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationComposeTheme {

                Surface(color = MaterialTheme.colors.background) {
                    LogIn()


                }
            }
        }
    }

    @Composable
    public fun LogIn() {
        var userName = remember {
            mutableStateOf("")
        }
        var password = remember {
            mutableStateOf("")
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalArrangement = Arrangement.Center,

        ) {
            Text(
                text = "Welcome to Login", fontSize = 20.sp, fontWeight = FontWeight.Bold,
                color = Color.Black, fontFamily = FontFamily.Monospace
            )
            OutlinedTextField(value = userName.value, onValueChange = {
                                                                      userName.value = it

            },
                leadingIcon = {
                    Icon(Icons.Default.Person, contentDescription = "username")
                },
                label = { Text(text = "Username") },
                placeholder = {
                    Text(text = "Enter Username")
                },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = password.value, onValueChange = {
password.value= it
                },
                leadingIcon = {
                    Icon(Icons.Default.Lock, contentDescription = "Password")
                },
                label = { Text(text = "Password") },
                placeholder = {
                    Text(text = "Enter password")
                },
                modifier = Modifier.fillMaxWidth().padding(top = 10.dp)
            )
            OutlinedButton(
                onClick = { logging(userName.value, password.value) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Login")

            }

        }
    }

    private fun logging(username: String, password: String) {
        if (username.equals("Barun") && password.equals("123456")) {
            Toast.makeText(this@LoginActivity, "LOGGED IN", Toast.LENGTH_SHORT).show()
            intent = Intent(this@LoginActivity,RrcyclerViewActivity::class.java)
            startActivity(intent);
            finish()
        } else {
            Toast.makeText(this@LoginActivity, "LOG IN FAILED", Toast.LENGTH_SHORT).show()

        }
    }

}


@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun PreviewLogin() {
    Surface(color = MaterialTheme.colors.background) {


    }

}
