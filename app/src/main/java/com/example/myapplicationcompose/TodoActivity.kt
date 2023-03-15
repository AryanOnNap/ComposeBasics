package com.example.myapplicationcompose

import android.icu.text.CaseMap.Title
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.example.myapplicationcompose.todo.Todo
import com.example.myapplicationcompose.todoDao.ui.TDViewModel
import com.example.myapplicationcompose.ui.theme.MyApplicationComposeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TodoActivity : ComponentActivity() {
 private val todoViewModel : TDViewModel by viewModels()
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
                val openDialog = remember {
                    mutableStateOf(false)
                }
                FloatingActionButton(onClick = {
                    openDialog.value = true
                }) {
                    CreateAlartDialog(openDialog = openDialog)
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ) {
            RecyclerView(todoViewModel = todoViewModel)
        }


    }

    @Composable
  fun  CreateAlartDialog(openDialog : MutableState<Boolean>)
    {
        val title = remember { mutableStateOf("") }
        val description = remember { mutableStateOf("") }
        if(openDialog.value){
            AlertDialog(onDismissRequest = {},
                title = {
                    Text(text = "ToDo")
                },
                text = {
                    Column (
                        modifier = Modifier
                            .padding(10.dp)
                            .fillMaxWidth()
                    ){
                        OutlinedTextField(value =title.value , onValueChange = {
                            title.value = it
                        },
                            placeholder = {
                                Text(text = "Enter Title")
                            },
                            label ={
                                Text(text ="Enter Description")
                            },
                            modifier = Modifier.padding(10.dp)
                        )
OutlinedTextField(value = description.value,
    onValueChange = {
        description.value = it
    },
    placeholder = {
        Text(text = "Enter Description")
    },
    label = {
        Text(text = "Enter description")
    }, modifier = Modifier.padding(10.dp)
)
                    }



                },
                confirmButton ={
                    OutlinedButton(onClick = {
                        insert(title,description)
                        openDialog.value = false
                    }) {
                        Text(text = "Save")

                    }
                }
            )
        }
    }


    private fun insert(title: MutableState<String>,description : MutableState<String>){
lifecycleScope.launchWhenCreated {
    if(!TextUtils.isEmpty(title.value) && TextUtils.isEmpty(description.value)){
        todoViewModel.insert(
            Todo(
                title.value,
                description.value
            )

        )

        Toast.makeText(this@TodoActivity,"Inserted Successfully",Toast.LENGTH_SHORT).show()

    }else{
        Toast.makeText(this@TodoActivity,"please fill all fields",Toast.LENGTH_SHORT).show()
    }
}
    }
    @Composable
    fun eachRow(todo: Todo){
        Card(
            modifier = Modifier
                .padding(horizontal = 10.dp, vertical = 10.dp)
                .fillMaxWidth()
                , elevation = 4.dp, shape = RoundedCornerShape(4.dp), backgroundColor = Color.Yellow

        ){
            Column(modifier = Modifier.padding(5.dp)) {
                Text(text = todo.title, fontWeight = FontWeight.ExtraBold)
                Text(text = todo.description, fontStyle = FontStyle.Italic)
            }
        }
    }
@Composable
fun RecyclerView(todoViewModel: TDViewModel){
    LazyColumn{
        items(todoViewModel.responce.value){todo ->
            eachRow(todo = todo)

        }
    }

}

}