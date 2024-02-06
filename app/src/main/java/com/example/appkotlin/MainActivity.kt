package com.example.appkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var tvHolaMundo: TextView
    lateinit var rootConstrainLayout:ConstraintLayout
    lateinit var buttonOk:Button
    lateinit var buttonCancel:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvHolaMundo=this.findViewById(R.id.tvHolaMundo)
        rootConstrainLayout=this.findViewById(R.id.rootConstrainLayout)
        buttonOk=this.findViewById(R.id.buttonOk)
        buttonCancel=this.findViewById(R.id.buttonCancel)


        buttonOk.setOnClickListener(this)

        buttonCancel.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if(v!!.id==R.id.buttonOk) {
            Log.v("MainActivity","Presioné OK")
            tvHolaMundo.text="Hasta Luego Mundo"
            rootConstrainLayout.setBackgroundColor(Color.MAGENTA)
        }
        else if(v!!.id==R.id.buttonCancel){
            Log.v("MainActivity","Presioné Cancel")
            tvHolaMundo.text="Volvemos atrás"
            rootConstrainLayout.setBackgroundColor(Color.YELLOW)
        }
    }
}