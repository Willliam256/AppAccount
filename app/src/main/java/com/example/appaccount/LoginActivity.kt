package com.example.appaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        auth = FirebaseAuth.getInstance()

        findViewById<Button>(R.id.login_btn).setOnClickListener {
            val email = findViewById<EditText>(R.id.email_login).text.toString()
            val password = findViewById<EditText>(R.id.password_login).text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()){
                auth.signInWithEmailAndPassword(email, password).addOnCompleteListener(){ task ->
                    if (task.isSuccessful){
                        val intent = Intent(this, HomeActivity::class.java)
                        intent.putExtra("email", email)
                        intent.putExtra("uId", auth.uid)
                        startActivity(intent)
                        finish()
                    }
                    else{
                        Toast.makeText(this, task.exception!!.localizedMessage, Toast.LENGTH_LONG).show()
                    }

                }
            }else Toast.makeText(this, "Fill in all The Fields", Toast.LENGTH_LONG).show()
        }
        findViewById<TextView>(R.id.no_account).setOnClickListener {
            startActivity(Intent(this, SignupActivity::class.java))
        }
    }
}