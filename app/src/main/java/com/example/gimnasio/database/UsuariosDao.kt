package com.example.gimnasio.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuariosDao {

    @Insert
    fun insertAll(vararg usuario: Usuario)

    @Query("SELECT * FROM Usuario")
    fun getAll(): LiveData<List<Usuario>>
}