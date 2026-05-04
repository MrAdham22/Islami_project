package com.example.islami_project.ui.theme.Screens.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.islami_project.R
import com.example.islami_project.ui.theme.Screens.main.fragments.hadith.HadethFragment
import com.example.islami_project.ui.theme.Screens.main.fragments.quran.QuranFragment
import com.example.islami_project.ui.theme.Screens.main.fragments.sebha.SebhaFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigation: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupGoldStatusBar()
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
                showFragment(HadethFragment())
            }
            R.id.sebha_Tab-> {
                showFragment(SebhaFragment())
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

    private fun setupGoldStatusBar() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.statusBarColor = android.graphics.Color.TRANSPARENT
        val statusBarGold = findViewById<View>(R.id.status_bar_gold)
        ViewCompat.setOnApplyWindowInsetsListener(statusBarGold) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.layoutParams?.let { lp ->
                lp.height = systemBars.top
                v.layoutParams = lp
            }
            insets
        }
        ViewCompat.requestApplyInsets(window.decorView)
    }
}