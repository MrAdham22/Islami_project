package com.example.islami_project.ui.theme.Screens.main.fragments.quran

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.islami_project.R
import com.example.islami_project.ui.theme.Constants
import com.example.islami_project.ui.theme.Screens.Sura_Details.Sura_Details_Activity

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
        surasAdapter = SurasAdapter(Constants.Suras){ sura ->
            val intent = Intent (context, Sura_Details_Activity::class.java)
            intent.putExtra(Sura_Details_Activity.SURA_KEY, sura)
            startActivity(intent)
        }
        surarecyclerView.adapter = surasAdapter
    }
}