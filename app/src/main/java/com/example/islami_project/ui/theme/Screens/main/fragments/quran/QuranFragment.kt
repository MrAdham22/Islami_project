package com.example.islami_project.ui.theme.Screens.main.fragments.quran

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_project.R
import com.example.islami_project.ui.theme.Constants

class QuranFragment : Fragment() {
    lateinit var surarecyclerView: RecyclerView
    lateinit var surasAdapter: SurasAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quran, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e("onviewcreated", "$view", )

        initSuraRecyclerView(view)


    }

    private fun initSuraRecyclerView(view: View) {
        surarecyclerView = view.findViewById(R.id.SurasRecycler)
        surasAdapter = SurasAdapter(Constants.Suras)
        surarecyclerView.adapter = surasAdapter
    }
}