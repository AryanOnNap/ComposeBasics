package com.example.myapplicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplicationcompose.data.dummyData
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class DiagramBox : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
//                    recyclerView(users = dummyData() )
                    Greetings(str = "How are you")
//                    eachRow("Android")
                }
            }
        }
    }

    @Composable

    fun Greetings( str : String){
        val mCounter = remember { mutableStateOf(0)}

            Column(
                modifier = Modifier
                    .background(color = Color.White)
                    .verticalScroll(rememberScrollState())
                    .paint(painterResource(id = R.drawable.bg_cal), contentScale = ContentScale.FillBounds)
                    .padding(10.dp)
                    .requiredHeight(1000.dp)
                    .clip(shape = RoundedCornerShape(30.dp)),


                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

            )


            {
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .border(3.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                    .requiredHeight(100.dp)
                    .weight(1f), elevation = 5.dp)

                {
                    Image(painter = painterResource(id = R.drawable.winter), contentDescription ="Image", contentScale = ContentScale.Crop )
                    Text(
                        text = "January", color = Color.White, modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 30.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = Color.Magenta,
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )


                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .border(3.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                    .requiredHeight(100.dp)
                    .weight(1f), elevation = 5.dp) {
                    Image(painter = painterResource(id = R.drawable.feb), contentDescription ="Image", contentScale = ContentScale.Crop )

                    Text(
                        text = "February", color = Color.Green, modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 30.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = Color.Magenta,
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )
                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .border(3.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                    .requiredHeight(100.dp)
                    .weight(1f), elevation = 5.dp) {
                    Image(painter = painterResource(id = R.drawable.summer), contentDescription ="Image", contentScale = ContentScale.Crop )
                    Text(
                        text = "March", color = Color.Green, modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 30.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = Color.Green,
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )

                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .border(3.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                    .requiredHeight(100.dp)
                    .weight(1f), elevation = 5.dp)

                {
                    Image(painter = painterResource(id = R.drawable.may), contentDescription ="Image", contentScale = ContentScale.Crop )
                    Text(
                        text = "April", color = Color.White, modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 30.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = Color.Yellow,
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )


                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .border(3.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                    .requiredHeight(100.dp)
                    .weight(1f), elevation = 5.dp)

                {
                    Image(painter = painterResource(id = R.drawable.monsoon), contentDescription ="Image", contentScale = ContentScale.Crop )
                    Text(
                        text = "May", color = Color.White, modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 30.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = Color.Cyan,
                                offset = Offset(5f, 5f),
                                blurRadius = 5f
                            )
                        )
                    )


                }
                Card(modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(15.dp))
                    .border(3.dp, color = Color.Black, shape = RoundedCornerShape(15.dp))
                    .requiredHeight(100.dp)
                    .weight(1f), elevation = 5.dp)

                {
                    Image(painter = painterResource(id = R.drawable.autunm), contentDescription ="Image", contentScale = ContentScale.Crop )
                    Text(
                        text = "June", color = Color.White, modifier = Modifier
                            .padding(5.dp)
                            .align(Alignment.Start)
                            .fillMaxWidth(), textAlign = TextAlign.Center, fontSize = 30.sp,  style = TextStyle(
                            shadow = Shadow(
                                color = Color.Yellow,
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
    @Composable
    @Preview(showBackground = false)
    fun MyPreview(){
        Greetings(str = "Hello")
    }
}