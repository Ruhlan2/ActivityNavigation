package com.ruhlan.activitynavigation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.ruhlan.activitynavigation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonLogin.setOnClickListener {
            val email = binding.editTextEmail.text.toString()
            val password = binding.editTextPassword.text.toString()
            val isChecked = binding.checkBoxRemember.isChecked

            if (email.isNotBlank() && password.isNotBlank()) {
                if (!email.contains("@gmail.com"))  {
                    binding.textErrorEmail.text = "Uygun olmayan format"
                } else {
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("EmailInfo",email).putExtra("PasswordInfo",password).putExtra("IsRememberme",isChecked)
                    startActivity(intent)
                }
            } else {
                binding.textErrorEmail.text = "Boş xana"
                binding.textErrorPassword.text = "Boş xana"
            }
        }
    }
}