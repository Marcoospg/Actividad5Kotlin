package com.example.appkotlin

import android.content.Intent
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

    lateinit var edtEmail: TextView
    lateinit var edtPassword: TextView
    lateinit var buttonSignUp:Button
    lateinit var buttonSignIn:Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtEmail=this.findViewById(R.id.edtEmail)
        edtPassword=this.findViewById(R.id.edtPassword)
        buttonSignUp=this.findViewById(R.id.buttonSignUp)
        buttonSignIn=this.findViewById(R.id.buttonSignIn)


        buttonSignUp.setOnClickListener(this)

        buttonSignIn.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        if(v!!.id==R.id.buttonSignUp) {

        }
        else if(v!!.id==R.id.buttonSignIn){
            var OnBoarding: Intent = Intent(this,OnBoarding::class.java)
            startActivity(OnBoarding)
            finish()
        }
    }
}