package com.example.gimnasio.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Usuario (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "nombre") val nombre: String?,
    @ColumnInfo(name = "apellidos") val apellidos: String?,
    @ColumnInfo(name = "sexo") val sexo: String?,
    @ColumnInfo(name = "edad") val edad: Int?
)