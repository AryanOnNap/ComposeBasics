package com.example.myapplicationcompose.todo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "todoTable")

data class Todo(
    val title : String ,
    val description:  String
){
    @PrimaryKey (autoGenerate = true)
    var id : Int? = null

}
