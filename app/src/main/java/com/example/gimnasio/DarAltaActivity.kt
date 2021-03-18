package com.example.gimnasio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.gimnasio.database.Usuario
import com.example.gimnasio.database.UsuarioDatabase
import kotlinx.android.synthetic.main.activity_dar_alta.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DarAltaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dar_alta)

        val database = UsuarioDatabase.getInstance(this)

        btn_guardar.setOnClickListener{
            val nombre = et_nombre.text.toString()
            val apellidos = et_apellidos.text.toString()
            val sexo = et_sexo.text.toString()
            val edad = et_edad.text.toString().toInt()

            val usuario = Usuario(0, nombre, apellidos, sexo, edad)

            CoroutineScope(Dispatchers.IO).launch {
                if (database != null) {
                    database.usuariosDao().insertAll(usuario)
                }
                this@DarAltaActivity.finish()
            }
        }

    }
}