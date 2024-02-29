package com.example.appkotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var edtEmail: TextView
    lateinit var edtPassword: TextView
    lateinit var buttonSignUp:Button
    lateinit var buttonSignIn:Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

        edtEmail=this.findViewById(R.id.edtEmail)
        edtPassword=this.findViewById(R.id.edtPassword)
        buttonSignUp=this.findViewById(R.id.buttonSignUp)
        buttonSignIn=this.findViewById(R.id.buttonSignIn)

        buttonSignUp.setOnClickListener(this)
        buttonSignIn.setOnClickListener(this)


    }


    override fun onClick(v: View?) {
        if(v!!.id==R.id.buttonSignUp) {

            var email:String=edtEmail.text.toString()
            var password:String=edtPassword.text.toString()

            //CREAR UN USUARIO EN FIREBASE AUTHENTICATION
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this)
                { task ->
                    if (task.isSuccessful) {
                        Log.d("MainActivity", "createUserWithEmail:success")
                        val user = auth.currentUser

                        var OnBoarding: Intent = Intent(this,OnBoarding::class.java)
                        startActivity(OnBoarding)
                        finish()

                        Toast.makeText(
                            baseContext,
                            "Correo electrónico registrado con éxito.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    } else {
                        Log.w("MainActivity", "createUserWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Correo electrónico ya registrado. Por favor, elija otro.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
        }
        else if(v!!.id==R.id.buttonSignIn){
            var OnBoarding: Intent = Intent(this,OnBoarding::class.java)
            startActivity(OnBoarding)
            finish()
        }
    }
}