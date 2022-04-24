package com.example.appaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        var joinBtn = findViewById<Button>(R.id.button)
        var haveAccount = findViewById<TextView>(R.id.textView2)

        joinBtn.setOnClickListener {
            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        haveAccount.setOnClickListener {
            var i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
    }
}