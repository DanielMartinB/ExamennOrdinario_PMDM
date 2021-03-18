package com.example.gimnasio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_usuario.*

class DetailUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_usuario)

        tvNombre.text = intent.getStringExtra("nombre").toString()
        tvApellidos.text = intent.getStringExtra("apellidos").toString()
        tvSexo.text = intent.getStringExtra("sexo").toString()
        tvEdad.text = intent.getIntExtra("edad", 0).toInt().toString() + " años"

        btn_addActividad.setOnClickListener{
            var dialog = DialogFragment()

            dialog.show(supportFragmentManager, "customDialog")
        }

    }
}