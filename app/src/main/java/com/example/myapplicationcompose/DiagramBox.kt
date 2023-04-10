package com.example.myapplicationcompose

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapplicationcompose.data.dummyData
import com.example.myapplicationcompose.navigation.NavigationScreen
import com.example.myapplicationcompose.navigation.StartNavigation
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme
import com.example.myapplicationcompose.util.ErrorUtils

open class DiagramBox : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    StartNavigation()
//                    recyclerView(users = dummyData() )
//                    Greetings(str = "How are you")
//                    eachRow("Android")
                }
            }
        }
    }

    @Composable
    fun Greetings( str : String,navHostController: NavHostController){
        val mCounter = remember { mutableStateOf(0)}
        var state = remember {
            mutableStateOf("")
        }
//        val colorTheme = colorResource(id = android.R.color.holo_red_light);
        val colorTheme = "colors";
        ErrorUtils.showLogs("DiagramBox","Greetings color is::"+colorTheme)

            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .verticalScroll(rememberScrollState())
                    .paint(
                        painterResource(id = R.drawable.city_bg),
                        contentScale = ContentScale.FillBounds
                    )
                    .padding(10.dp)
                    .requiredHeight(1000.dp)
                    .clip(shape = RectangleShape),


                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,

            )


            {
Text(text = "Month List", modifier = Modifier
    .fillMaxWidth()
    .weight(.6f)
    .align(Alignment.CenterHorizontally)
    .background(color = Color.Transparent, shape = RectangleShape).padding(0.dp,0.dp,0.dp,0.dp), color = Color.Gray, textAlign = TextAlign.Center, fontSize = 70.sp)
                Spacer(modifier = Modifier.height (20.dp))
                OutlinedTextField(value = state.value, onValueChange ={
                   state.value = it
                } , modifier = Modifier
                    .fillMaxWidth()
                    .weight(
                        0.2F
                    ))
                Card(
//                    onClick = {navHostController.navigate(NavigationScreen.calenderView.route},
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable(onClick = { navHostController.navigate(NavigationScreen.calenderView.route + "/$colorTheme") })
//
                        .clip(RoundedCornerShape(60.dp))
                        .border(3.dp, color = Color.Transparent, shape = RoundedCornerShape(60.dp))
                        .padding(10.dp)
                        .weight(1f), elevation = 10.dp)



                {
                    Image(painter = painterResource(id = R.drawable.winter), contentDescription ="Image", contentScale = ContentScale.Crop, modifier = Modifier
                        .fillMaxHeight()
//
                    )
                    Text(
                        text = "January", color = Color.Red, modifier = Modifier
                            .padding(0.dp)
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Magenta,
                                        Color.Transparent
                                    )
                                )
                            )
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 100.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = Color.Transparent,
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )


                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(60.dp))
                    .border(3.dp, color = Color.Transparent, shape = RoundedCornerShape(60.dp))
                    .padding(10.dp)
                    .weight(1f), elevation = 5.dp) {
                    Image(painter = painterResource(id = R.drawable.feb), contentDescription ="Image", contentScale = ContentScale.Crop,modifier = Modifier.fillMaxHeight() )

                    Text(
                        text = "February", color = Color.Transparent, modifier = Modifier
                            .padding(0.dp)
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Green,
                                        Color.Transparent
                                    )
                                )
                            )
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 100.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = colorResource(id = android.R.color.black),
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )
                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(60.dp))
                    .border(3.dp, color = Color.Transparent, shape = RoundedCornerShape(60.dp))
                    .padding(10.dp)

                    .weight(1f), elevation = 5.dp) {
                    Image(painter = painterResource(id = R.drawable.summer), contentDescription ="Image", contentScale = ContentScale.Crop,modifier = Modifier.fillMaxHeight() )
                    Text(
                        text = "March", color =  Color.Transparent, modifier = Modifier
                            .padding(0.dp)
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Gray,
                                        Color.Transparent
                                    )
                                )
                            )
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 100.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = colorResource(id = android.R.color.holo_blue_bright),
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )

                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(60.dp))
                    .border(3.dp, color = Color.Transparent, shape = RoundedCornerShape(60.dp))
                    .padding(10.dp)
                    .weight(1f), elevation = 5.dp)

                {
                    Image(painter = painterResource(id = R.drawable.may), contentDescription ="Image", contentScale = ContentScale.Crop,modifier = Modifier.fillMaxHeight() )
                    Text(
                        text = "April",color = Color.Transparent, modifier = Modifier
                            .padding(0.dp)
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Yellow,
                                        Color.Transparent
                                    )
                                )
                            )
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 100.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = colorResource(id = android.R.color.holo_blue_light),
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )


                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(60.dp))
                    .padding(10.dp)
                    .border(3.dp, color = Color.Transparent, shape = RoundedCornerShape(60.dp))
                    .weight(1f), elevation = 10.dp)
                {
                    Image(painter = painterResource(id = R.drawable.monsoon), contentDescription ="Image", contentScale = ContentScale.Crop,modifier = Modifier.fillMaxHeight() )
                    Text(
                        text = "May", color = Color.Transparent, modifier = Modifier
                            .padding(0.dp)
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.Cyan,
                                        Color.Transparent
                                    )
                                )
                            )
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 100.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = colorResource(id = android.R.color.holo_orange_dark),
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )


                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(60.dp))
                    .padding(10.dp)
                    .border(3.dp, color = Color.Transparent, shape = RoundedCornerShape(60.dp))
                    .weight(1f), elevation = 10.dp)

                {
                    Image(painter = painterResource(id = R.drawable.autunm), contentDescription ="Image", contentScale = ContentScale.Crop,modifier = Modifier.fillMaxHeight() )
                    Text(
                        text = "June", color = Color.Transparent, modifier = Modifier
                            .padding(0.dp)
                            .background(
                                Brush.horizontalGradient(
                                    colors = listOf(
                                        Color.White,
                                        Color.Transparent
                                    )
                                )
                            )
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 100.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = Color.Blue,
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )


                }


//                Column(
//                    modifier = Modifier
//                        .clip(shape = RectangleShape)
//                        .fillMaxWidth()
//                        .background(color = colorResource(R.color.orange))
//                        .border(5.dp, color = colorResource(id = R.color.teal_200))
//                        .weight(1f),verticalArrangement = Arrangement.Center
//
//
//                    , horizontalAlignment = Alignment.CenterHorizontally
//
//                ) {
//                    Card(modifier = Modifier
//                        .fillMaxWidth()
//                        .clip(shape = RectangleShape)
//                        .background(color = Color.Red)
//                    )
//
//
//                    {
////                        Box(modifier = Modifier.padding(2.dp)) {
////                            Image(painter = painterResource(id = R.drawable.girls_dp), contentDescription ="Image" )
////
////                        }
//                    }
////                    Text(
////                        text = str, color = Color.Blue, modifier = Modifier
////                            .padding(5.dp)
////                            .fillMaxWidth(), textAlign = TextAlign.Center
////                    )
//                }
//                Column(
//                    modifier = Modifier
//                        .clip(shape = RectangleShape)
//                        .background(color = colorResource(R.color.white))
//                        .border(5.dp, color = colorResource(id = R.color.teal_200))
//                        .weight(1f)
//
//                    ,verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
//
//                ) {
//                    Text(
//                        text = "Hope All Good", color = Color.Blue, modifier = Modifier
//                            .padding(5.dp)
//                            .fillMaxWidth(), textAlign = TextAlign.Center
//                    )
//                }
//                Column(modifier = Modifier
//                    .weight(1f)
//                    .border(5.dp, color = colorResource(id = R.color.teal_200)),verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
//                {
//                    CreateButton(text = "Click Me") {
//                        mCounter.value += 5
//                }
//
//                }
            }


    }
    @Preview
    @Composable

    fun MyPreview(){
        Greetings(str = "Hello", rememberNavController())
//        )

    }
    @Composable
    fun CreateButton(text:String, onClick: ()-> Unit){
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
        ){
            Text(text = text, color = Color.White)
        }
    }
//    @Composable
//    @Preview(showBackground = false)
//    fun MyPreview(navHostController: NavHostController){
//        Greetings(str = "Hello", navHostController
//        )
//    }
}