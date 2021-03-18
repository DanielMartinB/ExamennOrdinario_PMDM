package com.example.gimnasio

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gimnasio.adapter.UsuarioAdapter
import com.example.gimnasio.database.Usuario
import com.example.gimnasio.database.UsuarioDatabase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listaUsuarios = emptyList<Usuario>()
        val database = UsuarioDatabase.getInstance(this)

        if (database != null) {
            database.usuariosDao().getAll().observe(this, Observer {
                listaUsuarios = it
                rvUsuarios.layoutManager = LinearLayoutManager(this)
                val adapter = UsuarioAdapter(listaUsuarios)
                rvUsuarios.adapter = adapter
            })
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId) {
            R.id.about_us -> {
                startActivity(Intent(this, DarAltaActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}