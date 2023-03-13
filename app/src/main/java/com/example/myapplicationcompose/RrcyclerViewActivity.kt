package com.example.myapplicationcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationcompose.data.User
import com.example.myapplicationcompose.data.dummyData
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class RrcyclerViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background

                ) {
                    recyclerView(users = dummyData() )
//                    eachRow("Android")
                }
            }
        }
    }
}

@Composable
fun eachRow(user : User) {
   Card(
       modifier = Modifier
           .padding(horizontal = 8.dp, vertical = 8.dp)
           .fillMaxWidth(),
       shape = RoundedCornerShape(CornerSize(10.dp)),
       elevation = 2.dp
   ){
       Row(modifier = Modifier.padding(5.dp)){
           Image(painter = painterResource(id = R.drawable.girls_dp),
               contentDescription = "image",
           modifier = Modifier
               .padding(5.dp)
               .size(80.dp)
               .align(Alignment.CenterVertically)
               .clip(RoundedCornerShape(CornerSize(10.dp)))


           )
            Text(text = user.description, modifier = Modifier.padding(8.dp))
       }
   }
}
@Composable
fun recyclerView(users:List<User>){
    LazyColumn{
        items(users){user ->
eachRow(user  )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationComposeTheme {
//        eachRow("Android")
    }
}