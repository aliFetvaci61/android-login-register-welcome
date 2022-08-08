package com.example.myapplication

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ActivityMainRegisterBinding

class MainRegister : AppCompatActivity() {

    private lateinit var binding: ActivityMainRegisterBinding
    val username:String="username"
    val password:String="password"
    val spName:String="infos"
    val successMessage:String="Registration Successful"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backToLoginButon.setOnClickListener() {
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }
        binding.saveButton.setOnClickListener(){
            var username =  binding.registerUserName.text.toString()
            var password =  binding.registerPassword.text.toString()
            var SharedPreferences = this.getSharedPreferences(this.spName, MODE_PRIVATE)
            var editor = SharedPreferences.edit()

            editor.putString(this.username,"$username").apply()
            editor.putString(this.password,"$password").apply()
            Toast.makeText(applicationContext,successMessage, Toast.LENGTH_LONG).show()
            binding.registerPassword.text.clear()
            binding.registerUserName.text.clear()
            intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
        }

    }
}