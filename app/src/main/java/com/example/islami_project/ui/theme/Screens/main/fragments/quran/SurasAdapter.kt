package com.example.islami_project.ui.theme.Screens.main.fragments.quran

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_project.R
import com.example.islami_project.ui.theme.Model.SuraDM

class SurasAdapter (val suras : List<SuraDM> , val onClick : (SuraDM) -> Unit) : RecyclerView.Adapter<SurasAdapter.surasViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): surasViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_sura , parent , false)
        return surasViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: surasViewHolder,
        position: Int
    ) {
        val sura = suras[position]
        holder.suraNumber.text = "${sura.index}"
        holder.suraNameEN.text = sura.suranameEn
        holder.suraNameAR.text = sura.suranameAr
        holder.suraVerses.text = "${sura.versesNumber} Verses"
        holder.itemView.setOnClickListener {
            onClick(sura)
            Log.e( "sura adapter" , "$sura")
        }
    }

    override fun getItemCount(): Int = suras.size


    class surasViewHolder (view : View) : RecyclerView.ViewHolder (view){
        val suraNumber : TextView = view.findViewById(R.id.suranumber)
        val suraNameAR : TextView = view.findViewById(R.id.suraNameAr)
        val suraNameEN : TextView = view.findViewById<TextView>(R.id.suraNameEn)
        val suraVerses : TextView = view.findViewById<TextView>(R.id.versesNumber)


    }
}