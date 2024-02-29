package com.example.appkotlin

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var txtWelcome: TextView

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        txtWelcome = findViewById(R.id.txtWelcome)

        // Obtener el mensaje pasado desde OnBoarding
        val mensajeExtra = intent.getStringExtra("MENSAJE_EXTRA")
        if (!mensajeExtra.isNullOrBlank()) {
            txtWelcome.text = "BIENVENIDO A LA APP\n$mensajeExtra"
        }
    }
}