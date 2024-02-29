package com.example.appkotlin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet.Constraint
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class OnBoarding : AppCompatActivity(), OnClickListener {

    lateinit var edtEmail: TextView
    lateinit var edtPassword: TextView
    lateinit var buttonRegister:Button
    lateinit var buttonLogin:Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)

        auth = Firebase.auth

        edtEmail=this.findViewById(R.id.edtEmail)
        edtPassword=this.findViewById(R.id.edtPassword)
        buttonRegister=findViewById(R.id.buttonRegister)
        buttonRegister.setOnClickListener(this)

        buttonLogin=findViewById(R.id.buttonLogin)
        buttonLogin.setOnClickListener(this)

        main()
    }

    private fun main() {
        // Configura la interfaz principal aquí
        // Puedes realizar operaciones con los elementos de la interfaz si es necesario
        println("entro en el main")
        // Llama a la función cuerpo y pasa un color específico
        cuerpo(Color.rgb(178, 218, 250)) // Puedes cambiar el color según tus necesidades
    }

    private fun cuerpo(color: Int) {
        // Obtén la referencia al FrameLayout llamado frameMain
        val frameMain = findViewById<ConstraintLayout>(R.id.mainLayout)

        // Cambia el color de fondo del frameMain con el color proporcionado
        frameMain.setBackgroundColor(color)
    }

    override fun onClick(v: View?) {

        //VIAJAR AL MAINACTIVITY QUE ES DONDE TE REGISTRAS
        if(v!!.id==R.id.buttonRegister){
            var mainActivity: Intent = Intent(this,MainActivity::class.java)
            startActivity(mainActivity)
            finish()
        //INICIAR SESIÓN Y VIAJAR AL HOMEVIEW
        } else if(v!!.id==R.id.buttonLogin){

            var email:String=edtEmail.text.toString()
            var password:String=edtPassword.text.toString()

            auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this)
                { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d("OnBoarding", "Usuario logeado correctamente")
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