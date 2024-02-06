package com.example.appkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class OnBoarding : AppCompatActivity(), OnClickListener {

    lateinit var buttonRegister:Button
    lateinit var buttonLogin:Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        auth = Firebase.auth

        setContentView(R.layout.activity_on_boarding)
        buttonRegister=findViewById(R.id.buttonRegister)
        buttonRegister.setOnClickListener(this)

        buttonLogin=findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener(this)

    }

    override fun onClick(v: View?) {

        //VIAJAR AL MAINACTIVITY QUE ES DONDE TE REGISTRAS
        if(v!!.id==R.id.buttonRegister){
            var mainActivity: Intent = Intent(this,MainActivity::class.java)
            startActivity(mainActivity)
            finish()
        //INICIAR SESIÓN Y VIAJAR AL HOMEVIEW
        } else if(v!!.id==R.id.buttonLogin){

            var email:String="marcos@gmail.com"
            var password:String="1234567890"

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("OnBoarding", "signInWithEmail:success")
                        val user = auth.currentUser
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w("OnBoarding", "signInWithEmail:failure", task.exception)
                        Toast.makeText(
                            baseContext,
                            "Authentication failed.",
                            Toast.LENGTH_SHORT,
                        ).show()
                    }
                }
            var HomeView: Intent = Intent(this,HomeView::class.java)
            startActivity(HomeView)
            finish()
        }

    }

}