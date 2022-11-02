package com.example.mintic.room_database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import java.util.List


@Dao
interface ToDoDaD {
    @Query("SELECT * fROM ToDo")
    suspend fun getAllTasks(): List<ToDo>
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTask(task : ToDo): Long
    @Update
    suspend fun updateTask(task: ToDo)
    @Delete
    suspend fun deleteTask(task: ToDo)
}
