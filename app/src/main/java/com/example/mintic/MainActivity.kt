package com.example.sweethome

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.mintic.R
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    private var editUsername: EditText?= null
    private var editPassword : TextInputEditText?=null
    private val password_Pattern: Pattern = Pattern.compile(
        "^"+
                "(?=.*[0-9])"+
                "(?=.*[a-z])"+
                "(?=.*[A-Z])"+
                "(?=.*[^A-Za-z0-9])"+
                "(?=.*[@#\$%+=])"+
                "(?=\\S+$)"+
                ".{8,}"+
                "$"
    )

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        editUsername = findViewById(R.id.editUserName)
        editPassword = findViewById(R.id.editPassword)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnRegister?.setOnClickListener{
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        /* btnLogin?.setOnClickListener{
             val intent = Intent(this, NavegationActivity::class.java)
             startActivity(intent)
         }*/

    }

    fun onLogin(view: View) {

        if(ValidarLoguin()){
            Toast.makeText(this,"Usuario Correcto", Toast.LENGTH_LONG).show()

        } else{
            Toast.makeText(this,getString(R.string.usernoregistrado), Toast.LENGTH_LONG).show()
        }


    }

    private fun ValidarLoguin(): Boolean {
        var validar = true
        val emailInput = editUsername!!.text.toString()
        val passwordInput = editPassword!!.text.toString()

        if (editUsername!!.text.toString() == "sweet@home.com") {
            if (editPassword!!.text.toString() == "Sweet22+") {
                val negative={_:DialogInterface,_:Int->}
                val positivoBtn={dialog:DialogInterface,which:Int->

                    val intent = Intent(this, WelcomeActivity::class.java)
                    startActivity(intent)

                }


                val dialog=AlertDialog.Builder(this)
                    .setTitle(getString(R.string.text_welcome))
                    .setMessage("User: " +editUsername!!.text.toString())
                    .setPositiveButton("OK",positivoBtn)
                    .setNegativeButton("Cancelar",negative)
                    .create()
                    .show()

            }else{
                val dialog=AlertDialog.Builder(this)
                    .setTitle("Error")
                    .setMessage(getString(R.string.errorpassword))
                    .create()
                    .show()
                validar = false
            }
        }else {

            val dialog=AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(getString(R.string.erroruser))
                .create()
                .show()
            //Toast.makeText(this, getString(R.string.erroruser), Toast.LENGTH_SHORT).show()
            validar = false
        }



        if (TextUtils.isEmpty(editUsername!!.text.toString())) {
            editUsername!!.error = "Campo requerido"
            validar = false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            editUsername!!.error = "Debe ser un correo valido"
            validar = false
        } else editUsername!!.error = null

        if (TextUtils.isEmpty(editPassword!!.text.toString())) {
            editPassword!!.error = "Campo requerido"
            validar = false
        } else if (!password_Pattern.matcher(passwordInput).matches()) {
            editPassword!!.error = "Contraseña incorrecta"
            validar = false
        } else editPassword!!.error = null

        return validar

    }
}