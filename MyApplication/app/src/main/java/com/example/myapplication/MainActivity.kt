package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var preferences:SharedPreferences
    val username:String="username"
    val password:String="password"
    val warningMessage:String="Username or Password Wrong"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        preferences=getSharedPreferences("Infos", MODE_PRIVATE)
        setContentView(binding.root)
        binding.loginButton.setOnClickListener() {
            var registeredUsername = preferences.getString(this.username,"")
            var registeredPassword = preferences.getString(this.password,"")
            var username =  binding.loginUserName.text.toString()
            var password =  binding.loginPassword.text.toString()
            if(registeredUsername.equals(username) and registeredPassword.equals(password)){
                intent = Intent(applicationContext, MainWelcome::class.java)
                intent.putExtra(this.username,username)
                intent.putExtra(this.password,password)
                startActivity(intent)
            }
            else{
                Toast.makeText(applicationContext,warningMessage, Toast.LENGTH_LONG).show()
            }

        }
        binding.registerButon.setOnClickListener() {
            intent = Intent(applicationContext, MainRegister::class.java)
            startActivity(intent)
        }

    }
}