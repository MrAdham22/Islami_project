package com.example.islami_project.ui.theme.Screens.main.fragments.hadith

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_project.R
import com.example.islami_project.ui.theme.Model.HadethDM
import com.google.android.material.carousel.CarouselLayoutManager
import com.google.android.material.carousel.CarouselSnapHelper
import com.google.android.material.carousel.HeroCarouselStrategy


class HadethFragment : Fragment() {
     var ahadeth : MutableList<HadethDM> = emptyList<HadethDM>().toMutableList()
    lateinit var hadethAdapter: HadethAdapter
    lateinit var hadethRecycler: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadith, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intitRecycler()
    }

    private fun intitRecycler() {
        readAhadethfile()
        hadethRecycler = view!!.findViewById(R.id.hadethRecycler)

        hadethRecycler.layoutManager = CarouselLayoutManager(HeroCarouselStrategy())
        hadethAdapter = HadethAdapter(ahadeth)
        hadethRecycler.adapter = hadethAdapter

        val snapHelper = CarouselSnapHelper()
        snapHelper.attachToRecyclerView(hadethRecycler)

        hadethRecycler.clipToPadding = false
        val horizontalPadding = resources.getDimensionPixelSize(R.dimen.carousel_margin_horizontal)
        hadethRecycler.setPadding(horizontalPadding, 0, horizontalPadding, 0)
    }

    private fun readAhadethfile() {
        val inputStream = requireContext().assets.open("ahadeth/ahadeth.txt")
        var title = ""
        var content = ""
        inputStream.reader().forEachLine { line ->
            if (title.isEmpty()) {
                title = line.trim()
            } else {
                if (line.trim() == "#") {
                    ahadeth.add(HadethDM(title, content.trim()))
                    title = ""
                    content = ""
                    return@forEachLine
                }
                content += if (content.isEmpty()) line else "\n$line"
            }
        }
        if (title.isNotEmpty()) {
            ahadeth.add(HadethDM(title, content.trim()))
        }
    }
}