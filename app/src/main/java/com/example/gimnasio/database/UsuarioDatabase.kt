package com.example.gimnasio.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Usuario::class], version = 1)
abstract class UsuarioDatabase : RoomDatabase() {

    abstract fun usuariosDao(): UsuariosDao

    companion object {
        private const val DATABASE_NAME = "usuarios_database"

        @Volatile
        private var INSTANCE: UsuarioDatabase? = null

        fun getInstance(context: Context): UsuarioDatabase? {
            INSTANCE ?: synchronized(this){
                INSTANCE = Room.databaseBuilder(context.applicationContext, UsuarioDatabase::class.java, DATABASE_NAME).build()
            }
            return INSTANCE
        }
    }

}