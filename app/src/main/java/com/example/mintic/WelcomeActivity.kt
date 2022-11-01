package com.example.sweethome

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mintic.R
import com.example.mintic.ToDoActivity
import com.google.android.material.snackbar.Snackbar

class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val fab:View=findViewById(R.id.fab)
        fab.setOnClickListener { view->
            //Snackbar.make(view,"add",Snackbar.LENGTH_LONG).show()
            val intent = Intent(this, ToDoActivity::class.java)
            startActivity(intent)
        }

        /*if(savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.fragment_container_view,ToDoFragment::class.java,null,"todo")
                .commit()
        }

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener{view ->
            Snackbar.make(view,R.string.fab_text, Snackbar.LENGTH_LONG)
                .setAction("Action",null)
                .show()
        }*/
    }

}