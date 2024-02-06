package com.example.appkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun clickOk(v: View){
        Log.v("MainActivity","Presioné OK")
    }

    fun clickCancel(v: View){
        Log.v("MainActivity","Presioné Cancel")
    }
}