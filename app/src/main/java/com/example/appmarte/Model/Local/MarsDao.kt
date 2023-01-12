package com.example.appmarte.Model.Local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.appmarte.Model.Remote.MarsRealState


@Dao
interface MarsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTask( task: MarsRealState)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun inserAllTask( task: List<MarsRealState>)

    @Update
    suspend fun updateTask(task: MarsRealState)

    @Delete
    suspend fun deleteTask(task: MarsRealState)

    @Query("DELETE FROM mars_table")
    suspend fun deleteAll()

    // TRAE TODAS LAS TAREAS
    @Query("SELECT * FROM mars_table ORDER BY id DESC")
    fun getAllTask():LiveData<List<MarsRealState>>

    // filtrar por titulo
    @Query("SELECT * FROM mars_table WHERE type = :type LIMIT 1")
    fun getTaskByType( type:String): LiveData<MarsRealState>

    // filtrar por id

    @Query("SELECT * FROM mars_table WHERE id = :id")
    fun getTaskByType( id:Int): LiveData<MarsRealState>


}