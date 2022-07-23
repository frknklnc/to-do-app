package com.example.todoapp.room

import androidx.room.*
import com.example.todoapp.data.entity.ToDo

@Dao
interface ToDoDao {
    @Query("SELECT * FROM todo")
    suspend fun tumJob() : List<ToDo>

    @Insert
    suspend fun jobEkle(job:ToDo)

    @Update
    suspend fun jobGuncelle(job:ToDo)

    @Delete
    suspend fun jobSil(job:ToDo)

    @Query("SELECT * FROM todo WHERE yapilacak_is like '%' || :aramaKelimesi || '%'")
    suspend fun jobAra(aramaKelimesi:String) : List<ToDo>
}