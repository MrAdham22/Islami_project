package com.example.islami_project.ui.theme.Screens.main.fragments.hadith

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_project.R
import com.example.islami_project.ui.theme.Model.HadethDM



class HadethAdapter(val ahadeth : List<HadethDM>) :  RecyclerView.Adapter<HadethAdapter.HadethViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): HadethViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_hadeth , parent , false)
        return HadethViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: HadethViewHolder,
        position: Int
    ) {
        holder.bind(position)
    }


    override fun getItemCount(): Int = ahadeth.size


    inner class HadethViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        val hadethTitle = itemview.findViewById<TextView>(R.id.hadethTitle)
        val hadethContent = itemview.findViewById<TextView>(R.id.hadethContent)

        fun bind (position: Int){
            val hadeth = ahadeth[position]
            hadethTitle.text = hadeth.title
            hadethContent.text = hadeth.content
        }

    }
}