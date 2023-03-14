package com.example.myapplicationcompose.todoDao

import com.example.myapplicationcompose.todo.Todo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TodoRepository
    @Inject
    constructor(private val dao :DaoInterface){

    suspend fun insert(todo: Todo) = withContext(Dispatchers.IO){
        dao.insert(todo)
    }

fun getAllTodos(): Flow<List<Todo>> = dao.getAllTodos();

    }
