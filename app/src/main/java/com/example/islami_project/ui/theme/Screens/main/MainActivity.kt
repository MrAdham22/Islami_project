package com.example.islami_project.ui.theme.Screens.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.islami_project.R
import com.example.islami_project.ui.theme.Screens.main.fragments.hadith.HadithFragment
import com.example.islami_project.ui.theme.Screens.main.fragments.quran.QuranFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        bottomNavigation = findViewById(R.id.navbar)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, QuranFragment())
            .commit()

        bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
            R.id.quran_Tab -> {
                showFragment(QuranFragment())
            }
            R.id.hadeth_Tab -> {
                showFragment(HadithFragment())
            }
            R.id.sebha_Tab-> {
                Toast.makeText(this, "Task", Toast.LENGTH_SHORT).show()
                return@setOnItemSelectedListener false
            }
            R.id.radio_Tab -> {
                Toast.makeText(this, "not impleneted yet", Toast.LENGTH_SHORT).show()
                return@setOnItemSelectedListener false
            }

            }
            return@setOnItemSelectedListener true

        }
    }
    fun showFragment (fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}