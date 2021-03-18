package com.example.gimnasio.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gimnasio.DetailUsuarioActivity
import com.example.gimnasio.R
import com.example.gimnasio.database.Usuario
import kotlinx.android.synthetic.main.item_usuario.view.*

class UsuarioAdapter(val usuario: List<Usuario>): RecyclerView.Adapter<UsuarioAdapter.UsuarioHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return UsuarioHolder(layoutInflater.inflate(R.layout.item_usuario, parent, false))
    }

    override fun getItemCount(): Int {
        return usuario.size
    }

    override fun onBindViewHolder(holder: UsuarioHolder, position: Int) {
        holder.render(usuario[position])
    }

    class UsuarioHolder(val view: View): RecyclerView.ViewHolder(view) {

        fun render(usuario: Usuario) {
            view.tvNombre.text = usuario.nombre
            view.setOnClickListener{
                val context = view.context
                val intent = Intent(context, DetailUsuarioActivity::class.java)
                intent.putExtra("nombre", view.tvNombre.text.toString())
                intent.putExtra("apellidos", usuario.apellidos.toString())
                intent.putExtra("sexo", usuario.sexo.toString())
                intent.putExtra("edad", usuario.edad.toString().toInt())
                context.startActivity(intent)
            }
        }
    }
}