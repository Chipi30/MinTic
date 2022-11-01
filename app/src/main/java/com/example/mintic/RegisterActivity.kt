package com.example.sweethome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.View
import android.widget.*
import com.example.mintic.R
import com.google.android.material.textfield.TextInputEditText
import java.util.regex.Pattern

class RegisterActivity : AppCompatActivity() {

    private var userName : EditText? = null
    private var userLastName : EditText? = null
    private var nit : EditText? = null
    private var phone : EditText? = null
    private var email : EditText? = null
    private var editPassword : EditText?=null
    private var checkpolicies: CheckBox?=null

    private val text_Pattern: Pattern = Pattern.compile(
        "[a-zA-Z]*"
    )

    private val number_Pattern: Pattern= Pattern.compile(
        "[0-9]*"
    )

    private val password_Pattern: Pattern= Pattern.compile(
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        userName = findViewById(R.id.userName)
        userLastName = findViewById(R.id.userLastName)
        nit = findViewById(R.id.nit)
        phone = findViewById(R.id.phone)
        email = findViewById(R.id.email)
        editPassword = findViewById(R.id.editPassword)
        checkpolicies = findViewById(R.id.checkpolicies)

        val link_to_login = findViewById<TextView>(R.id.link_to_login)

        link_to_login?.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

    }


    fun onRegistro(view: View) {
        if(ValidarForm()){
            Toast.makeText(this,"Registro correcto", Toast.LENGTH_LONG).show()
            //para redirigir al welcome
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
        } else{
            Toast.makeText(this,"Error de datos", Toast.LENGTH_LONG).show()
        }

    }

    private fun ValidarForm(): Boolean {
        var validate = true
        val nameInput = userName!!.text.toString()
        val lastnameInput = userLastName!!.text.toString()
        val nitInput = nit!!.text.toString()
        val phoneInput = phone!!.text.toString()
        val emailInput = email!!.text.toString()
        val passwordInput = editPassword!!.text.toString()
        //val passwordInput = editPassword?.text.toString()

        if (!checkpolicies!!.isChecked) {
            checkpolicies!!.error="Falta aceptar politicas"
            validate = false
        }else checkpolicies!!.error = null
        if (TextUtils.isEmpty(userName!!.text.toString())) {
            userName!!.error = "Campo requerido"
            validate = false
        } else if (!text_Pattern.matcher(nameInput.replace(" ", "")).matches()) {
            userName!!.error = "Nombre no valido"
            validate = false
        } else userName!!.error = null

        if (TextUtils.isEmpty(userLastName!!.text.toString())) {
            userLastName!!.error = "Campo requerido"
            validate = false
        } else if (!text_Pattern.matcher(lastnameInput.replace(" ", "")).matches()) {
            userLastName!!.error = "Apellido no valido"
            validate = false
        } else userLastName!!.error = null


        if (TextUtils.isEmpty(nit!!.text.toString())) {
            nit!!.error = "Campo requerido"
            validate = false
        } else if (!number_Pattern.matcher(nitInput).matches()) {
            nit!!.error = "Deben ser números"
            validate = false
        } else nit!!.error = null

        if (TextUtils.isEmpty(phone!!.text.toString())) {
            phone!!.error = "Campo requerido"
            validate = false
        } else if (!number_Pattern.matcher(phoneInput).matches()) {
            phone!!.error = "Deben ser números"
            validate = false
        } else phone!!.error = null

        if (TextUtils.isEmpty(email!!.text.toString())) {
            email!!.error = "Campo requerido"
            validate = false
        }
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            email!!.error = "Debe ser un correo valido"
            validate = false
        } else email!!.error = null

        if (TextUtils.isEmpty(editPassword!!.text.toString())) {
            editPassword!!.error = "Campo requerido"
            validate = false
        } else if (!password_Pattern.matcher(passwordInput).matches()) {
            editPassword!!.error = "No cumple con los criterios de contraseña"
            validate = false
        } else editPassword!!.error = null


        return validate
    }

}
