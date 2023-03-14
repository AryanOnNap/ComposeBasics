package com.example.myapplicationcompose.todoDao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplicationcompose.todo.Todo

@Database (entities = [Todo ::class], version = 1, exportSchema = false)
abstract class Tododatabase : RoomDatabase() {
abstract fun getDao() : DaoInterface
}