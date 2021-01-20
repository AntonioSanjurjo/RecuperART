package com.example.recuperart.ui.descubre

import android.content.Context
import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.recuperart.R
import com.example.recuperart.data.ExperienceData
import com.example.recuperart.io.Constantes
import com.example.recuperart.io.model.Obra


class ObrasRecyclerViewAdapter(private val context: Context
) : RecyclerView.Adapter<ObrasRecyclerViewAdapter.ViewHolder>() {

    private var obras: ArrayList<Obra> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_o, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = obras[position]
        holder.titulo.text = item.nom
        holder.autor.text = "Autor: " + item.autor
        holder.tipo.text = item.tipus
        holder.descripcio.text = item.descrpcio
    }

    override fun getItemCount(): Int = obras.size

    fun setData(allObras: ArrayList<Obra>?) {
        obras = allObras!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.titulo_obra)
        val autor: TextView = view.findViewById(R.id.autor_obra)
        val tipo: TextView = view.findViewById(R.id.tipo_obra)
        val descripcio: TextView = view.findViewById(R.id.descripcion_obra)
        init {
            view.setOnClickListener{
                val adapterPosition = adapterPosition
                if (adapterPosition == RecyclerView.NO_POSITION) {
                    return@setOnClickListener
                }
                val item = obras[adapterPosition]
                Constantes.ID_OBRA=item.id.toString()
                ExperienceData.nom_obra = item.nom + ", " + item.autor
                context?.startActivity(Intent(context, ImagenObra::class.java).putExtra("obraNom", item.nom))
            }
        }
    }
}