package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityMainWelcomeBinding

class MainWelcome : AppCompatActivity() {
    private lateinit var binding: ActivityMainWelcomeBinding
    val username:String="username"
    val password:String="password"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textViewUsername.text = "Username : " + intent.getStringExtra(this.username)
        binding.textViewPassword.text = "Password : " + intent.getStringExtra(this.password)
        binding.exitButon.setOnClickListener() {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }
}