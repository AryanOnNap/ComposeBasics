package com.example.myapplicationcompose

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationcompose.navigation.StartNavigation
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme
import com.example.myapplicationcompose.util.ErrorUtils
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.MaterialDialogState
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class CalenderView : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
//                    calender(color = )

//                    recyclerView(users = dummyData() )
//                    Greetings(str = "How are you")
//                    eachRow("Android")
                }



            }
        }
    }
    @Composable

     fun calender(color : String) {
        var pickedDate by remember {
            mutableStateOf(LocalDate.now())
        }
        var pickedTime by remember {
            mutableStateOf(LocalTime.NOON)
        }
        val formattedDate by remember {
            derivedStateOf {
                DateTimeFormatter
                    .ofPattern("MMM dd yyyy")
                    .format(pickedDate)
            }

        }
        ErrorUtils.showLogs("CalenderView","calender color is :::"+color)

        val formattedTime by remember {
            derivedStateOf {
                DateTimeFormatter
                    .ofPattern("hh : mm")
                    .format(pickedTime)
            }

        }
        val dateDialogState = rememberMaterialDialogState();
        val timeDialogState = rememberMaterialDialogState()

        CreateCalender(dateDialogState = dateDialogState, timeDialogState = timeDialogState, date = formattedDate, time = formattedTime)

        MaterialDialog(dialogState = dateDialogState,
            buttons = {
                positiveButton("OK ") {
                    Toast.makeText(this@CalenderView, "Ok Clicked::", Toast.LENGTH_SHORT)
                        .show()

                }
                negativeButton("Cancel") {
                    Toast.makeText(this@CalenderView, "Cancel Clicked", Toast.LENGTH_SHORT)
                        .show()

                }
            }) {
            datepicker(
                initialDate = LocalDate.now(),
                title = "Pick a date",
                allowedDateValidator = {
                    it.dayOfWeek !== DayOfWeek.SATURDAY ||
                            it.dayOfWeek !== DayOfWeek.SUNDAY
                }

            ) {
                pickedDate = it
            }
        }



        MaterialDialog(dialogState = timeDialogState,
            buttons = {
                positiveButton("OK ") {
                    Toast.makeText(this@CalenderView, "Ok Clicked", Toast.LENGTH_SHORT)
                        .show()
                    val intent = Intent(this@CalenderView,DiagramBox::class.java)
                    startActivity(intent)

                }
                negativeButton("Cancel") {
                    Toast.makeText(this@CalenderView, "Cancel Clicked", Toast.LENGTH_SHORT)
                        .show()

                }
            }) {
            timepicker(
                initialTime = LocalTime.now(),
                title = "Pick a time",
                timeRange = LocalTime.MIDNIGHT .. LocalTime.NOON

            ) {
                pickedTime = it
            }
        }
    }

    @Composable
    fun CreateCalender(dateDialogState: MaterialDialogState, timeDialogState : MaterialDialogState, date : String, time : String) {
        Column(
            modifier = Modifier.fillMaxSize().background(color = Color.Magenta, shape = RectangleShape),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Button(onClick = { dateDialogState.show() }) {

                Text(text = "Pick date")
            }
            Text(text = date)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { timeDialogState.show() }) {

                Text(text = "Pick date")
            }
            Text(text = time)
            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}


