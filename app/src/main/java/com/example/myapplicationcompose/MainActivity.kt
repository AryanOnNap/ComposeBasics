package com.example.myapplicationcompose

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.graphics.Color
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplicationcompose.data.SampleData
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme

class MainActivity : ComponentActivity () {
    var message = Message("I am","developer")
    var img = R.drawable.girls_dp;
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate (savedInstanceState: Bundle?) {
        super . onCreate (savedInstanceState)
        setContent {
            MyApplicationComposeTheme {
                Scaffold(topBar = {
                    TopAppBar(title = {
                        Text(text = "TOP BAR", color = androidx.compose.ui.graphics.Color.Black)
                    }, backgroundColor = MaterialTheme.colors.error, contentColor = MaterialTheme.colors.primary,
                        navigationIcon = { IconButton(
                        onClick = {}){
                        Icon(    imageVector = ImageVector.vectorResource(id = R.drawable.baseline_menu_24),
                            contentDescription = "Menu",)
                    }
                        


                    },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {Icon(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_notifications_24),contentDescription = "noti",)

                        }
                        IconButton(onClick = { /*TODO*/ }) {Icon(imageVector = ImageVector.vectorResource(id = R.drawable.baseline_search_24)
                            , contentDescription = "Search")

                        }
                    })

                },floatingActionButton = {
                    IconButton(onClick = { }) {
                        Icon(Icons.Filled.Add, contentDescription = "floatButton")
                    };
                }, floatingActionButtonPosition = FabPosition.End) {Conversation(SampleData.conversationSample)
                }


                    
                }
        }
            }

                    

//                Conversation(SampleData.conversationSample)
            }
//            MessageCard(message )



data class Message(val author: String, val body: String)
//@Composable
//fun Conversation(messages: List<Message>) {
//    LazyColumn {
//        items(messages) { message ->
//            MessageCard(message)
//        }
//    }
//}
data class City(val name: String, val country: String)

val CitySaver = listSaver<City, Any>(
    save = { listOf(it.name, it.country) },
    restore = { City(it[0] as String, it[1] as String) }
)

@Composable
fun Conversation(messages: List<Message>) {
    LazyColumn {
        items(messages) { message->
            MessageCard(message)
        }
    }
}


@Composable
fun MessageCard (msg : Message) {
    Row{
        Image(
            painter = painterResource(id= R.drawable.girls_dp),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .alpha(8.9F)
                .size(40.dp)
                .border(1.5.dp, MaterialTheme.colors.error, CircleShape)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Spacer(modifier = Modifier.width(9.dp))
        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary else MaterialTheme.colors.error,
        )

    Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
        Spacer(modifier = Modifier.width(4.dp))
        Spacer(modifier = Modifier.height(3.dp))
        Text(text = msg.author ,color =  MaterialTheme.colors.error, style = MaterialTheme.typography.subtitle2, modifier = Modifier.padding(all = 4.dp))


        Surface(
            shape = MaterialTheme.shapes.medium,
            elevation = 1.dp,
            color = surfaceColor,
            modifier = Modifier
                .animateContentSize()
                .padding(1.dp)
        ) {


            Text(
                text = msg.body,
                modifier = Modifier.padding(start = 0.dp, end = 0.dp, top = 4.dp, bottom = 4.dp),
                // If the message is expanded, we display all its content
                // otherwise we only display the first line
                maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                style = MaterialTheme.typography.body2

            )
        }
        Spacer(modifier = Modifier.padding(3.dp,3.dp))
        Spacer(modifier = Modifier.width(30.dp))


    }
    }


}

@Preview( uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode")
@Composable
fun PreviewConversation() {
    MyApplicationComposeTheme {
        Conversation(SampleData.conversationSample)
    }
}



//@Preview( uiMode = Configuration.UI_MODE_NIGHT_YES,
//        showBackground = true,
//        name = "Dark Mode")
//    @Composable
//    fun PreviewMessageCard() {
//        var message = Message("I am","developer")
//        MessageCard(message)
//    }

