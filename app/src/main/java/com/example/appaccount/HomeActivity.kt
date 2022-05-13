package com.example.appaccount

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appaccount.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private  lateinit var binding:ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}