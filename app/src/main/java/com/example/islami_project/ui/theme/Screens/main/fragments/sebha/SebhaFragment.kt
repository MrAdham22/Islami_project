package com.example.islami_project.ui.theme.Screens.main.fragments.sebha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.fragment.app.Fragment
import com.example.islami_project.R


class SebhaFragment : Fragment() {
    var sebhaBody : ImageView? = null
    var azkarText : TextView? = null
    var azkarCounter : TextView? = null
    var counter = 0

    val azkarList = listOf<String>("سبحان الله","الحمد لله","الله اكبر","لا اله الا الله","")
    var index = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val view = inflater.inflate(R.layout.fragment_sebha, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        azkarText?.text = azkarList[index]
        sebhaBody?.setOnClickListener {
            sebhaBody?.animate()?.rotationBy(36f)?.start()
            azkarText?.text = azkarList[index]
            counter++
            tasbehLimit()
            azkarCounter?.text = counter.toString()
        }

    }

    private fun tasbehLimit() {
            if (counter == 3) {
                counter = 0
                index++

                if (index < azkarList.size) {
                    azkarText?.text = azkarList[index]
                } else {
                    azkarText?.text = "تم الانتهاء"
                    return
                }
            }

    }

    private fun initViews(){
        sebhaBody = view?.findViewById<ImageView>(R.id.sebha_Body)
        azkarText = view?.findViewById<TextView>(R.id.tasbehName)
        azkarCounter = view?.findViewById<TextView>(R.id.tasbehNumber)

    }
}