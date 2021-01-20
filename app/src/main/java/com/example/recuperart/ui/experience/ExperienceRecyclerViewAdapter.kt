package com.example.recuperart.ui.experience

import android.content.Context
import android.graphics.Color
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.example.recuperart.R
import com.example.recuperart.data.Experience

class ExperienceRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<ExperienceRecyclerViewAdapter.ViewHolder>() {
    private var allExperiences = emptyList<Experience>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item_e, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = allExperiences[position]
        holder.museo.text = item.nom_museo
        holder.obra.text = item.nom_obra
        holder.animoinicial.setBackgroundColor(Color.parseColor(item.colorstart))
        holder.cancion.text = item.cancion
        holder.escribe.text = item.escribe
        holder.wordcloud.setImageBitmap(item.workcloud)
        holder.dibuja.setImageBitmap(item.dibujo)
        holder.revisita.text = item.revisita
        holder.animofinal.setBackgroundColor(Color.parseColor(item.colorend))
    }

    override fun getItemCount(): Int = allExperiences.size

    fun setData(experience: List<Experience>?) {
        allExperiences = experience!!
        notifyDataSetChanged()
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val museo: TextView = view.findViewById(R.id.museo_e)
        val obra: TextView = view.findViewById(R.id.obra_e)
        val cancion: TextView = view.findViewById(R.id.cancion_e)
        val escribe: TextView = view.findViewById(R.id.escribe_e)
        val wordcloud: ImageView = view.findViewById(R.id.wordcloud_e)
        val dibuja: ImageView = view.findViewById(R.id.dibuja_e)
        val revisita : TextView = view.findViewById(R.id.revisita_e)
        val animoinicial : LinearLayout = view.findViewById(R.id.mood)
        val animofinal : LinearLayout = view.findViewById(R.id.moodfinal)
    }
}