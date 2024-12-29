package com.ruhlan.activitynavigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruhlan.activitynavigation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val emailAddress =intent.getStringExtra("EmailInfo")
        val password = intent.getStringExtra("PasswordInfo")
        val rememberMe = intent.getBooleanExtra("IsRememberme",false)

        binding.textViewEmail.text = emailAddress
        binding.textViewPassword.text = "$password $rememberMe"



        binding.button.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}