package com.example.appkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class OnBoarding : AppCompatActivity(), OnClickListener, OnLongClickListener {

    lateinit var buttonRegister:Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        setContentView(R.layout.activity_on_boarding)
        buttonRegister=findViewById(R.id.buttonRegister)
        buttonRegister.setOnClickListener(this)
        buttonRegister.setOnLongClickListener(this)

    }

    override fun onClick(v: View?) {


        if(v!!.id==R.id.buttonRegister){
            var mainActivity: Intent = Intent(this,MainActivity::class.java)
            startActivity(mainActivity)
            finish()
        }

    }

    override fun onLongClick(v: View?): Boolean {
        if(v!!.id==R.id.buttonRegister){

        }
        return true
    }
}