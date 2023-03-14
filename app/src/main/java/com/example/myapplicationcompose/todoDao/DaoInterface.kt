package com.example.myapplicationcompose.todoDao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplicationcompose.todo.Todo
import kotlinx.coroutines.flow.Flow

@Dao
interface DaoInterface {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(todo: Todo)


    @Query("SELECT * FROM todoTable"    )
    fun getAllTodos(): Flow<List<Todo>>

}