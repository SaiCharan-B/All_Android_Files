package com.example.buddychat

/*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            val email = editTextTextEmailAddress.toString()
            val password = editTextTextPassword.toString()

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    email,
                    password
            )
            startActivity(Intent(this,ChatActivity.class,))
        }
    }
}*/

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            val email = editTextTextEmailAddress.text.toString()
            val password = editTextTextPassword.text.toString()

            FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                email,
                password
            )
            startActivity(Intent(this,ChatActivity::class.java))
        }
    }
}
