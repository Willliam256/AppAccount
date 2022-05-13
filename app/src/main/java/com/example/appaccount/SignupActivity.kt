package com.example.appaccount

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class SignupActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        auth = FirebaseAuth.getInstance()

        findViewById<Button>(R.id.register_btn).setOnClickListener {

            val uName = findViewById<EditText>(R.id.user_name).text.toString()
            val email = findViewById<EditText>(R.id.email_register).text.toString()
            val passWord = findViewById<EditText>(R.id.password_register).text.toString()
            val confirmPassword = findViewById<EditText>(R.id.confirm_password_register).text.toString()

            if (uName.isNotEmpty() && email.isNotEmpty() && passWord.isNotEmpty() && confirmPassword.isNotEmpty()){
                if(passWord == confirmPassword){
                    auth.createUserWithEmailAndPassword(email, passWord).addOnCompleteListener{task ->
                            if (task.isSuccessful){
                                Toast.makeText(this, "Account Has Been Created For $uName", Toast.LENGTH_LONG).show()
                                val intent = Intent(this, LoginActivity::class.java)
                                startActivity(intent)
                                finish()
                            }
                        }
                }else{
                    Toast.makeText(this, "The Password is Not Matching", Toast.LENGTH_LONG).show()
                }

            }else{
                Toast.makeText(this, "Fill In All the fields", Toast.LENGTH_LONG).show()
            }

        }

        findViewById<TextView>(R.id.textView2).setOnClickListener {
            val i = Intent(this, LoginActivity::class.java)
            startActivity(i)
        }
    }
}