package com.example.prueba_desconecta.ui.descubre

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.prueba_desconecta.R
import com.example.prueba_desconecta.ui.Museo
import com.example.prueba_desconecta.ui.Obra

class ObrasRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<ObrasRecyclerViewAdapter.ViewHolder>() {

    private var obras: ArrayList<Obra> = ArrayList()
    private var museo: Museo = Museo()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_o, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = obras [position]
        holder.autor.text = item.autor
        holder.nom.text = item.nom
        holder.descripcio.text = item.descripcion
    }

    override fun getItemCount(): Int = obras.size

    fun setData(museo: Museo, allobras: ArrayList<Obra>?) {
        this.museo= museo
        this.obras = allobras!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nom: TextView = view.findViewById(R.id.obra_nom)
        val autor: TextView = view.findViewById(R.id.obra_autor)
        val descripcio: TextView = view.findViewById(R.id.obra_descripcio)
    }
}