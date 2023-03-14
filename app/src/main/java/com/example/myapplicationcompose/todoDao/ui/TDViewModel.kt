package com.example.myapplicationcompose.todoDao.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationcompose.todo.Todo
import com.example.myapplicationcompose.todoDao.TodoRepository
import com.example.myapplicationcompose.util.ErrorUtils
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class TDViewModel
    constructor(private val todoRepository: TodoRepository) : ViewModel(){
    private val TAG = javaClass.simpleName
    val responce :MutableState<List<Todo>> = mutableStateOf(listOf())
        fun insert (todo: Todo) = viewModelScope.launch {

        }
    init{
        getAllTodos()
    }

    fun getAllTodos() = viewModelScope.launch {
        todoRepository.getAllTodos()
            .catch{e->
                ErrorUtils.showLogs(TAG,"EXCEPTION IS ::::"+e.message)

            }.collect{
                responce.value = it
            }
    }



    }

