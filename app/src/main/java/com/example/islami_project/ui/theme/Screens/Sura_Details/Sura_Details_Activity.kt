package com.example.islami_project.ui.theme.Screens.Sura_Details

import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import com.example.islami_project.R
import com.example.islami_project.ui.theme.Model.SuraDM

class Sura_Details_Activity : AppCompatActivity() {
    lateinit var nameAr: TextView
    lateinit var nameEn: TextView
    lateinit var sura : SuraDM
    lateinit var backarrow : ImageView
    lateinit var suraContenttextview : TextView
    companion object{
        const val SURA_KEY = "sura"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sura_details)
        initViews()
        readsurafile()
        initlisteners()
    }

    private fun readsurafile() {
        val filename = "quran/${sura.index}.txt"
        val inputStream = assets.open(filename)
        var suraContent = ""
        var i = 1
        inputStream.reader().forEachLine { line ->
            if (line.isNotEmpty()) {
                suraContent += "$line {$i}"
                i++
            }
        }
        suraContenttextview.text = suraContent

    }


    private fun initlisteners() {
        backarrow.setOnClickListener {
            finish()
        }
    }

    private fun initViews() {
        sura = (if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) intent.getSerializableExtra(
            SURA_KEY,
            SuraDM::class.java
        )else intent.getSerializableExtra(SURA_KEY) as SuraDM)!!

        nameAr = findViewById(R.id.suraNameAr)
        nameEn = findViewById(R.id.suraNameEn)
        backarrow = findViewById(R.id.back_arrow)
        suraContenttextview = findViewById(R.id.sura_Details)

        nameAr.text = sura.suranameAr
        nameEn.text = sura.suranameEn
    }

}