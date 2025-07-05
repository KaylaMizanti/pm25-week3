package com.example.assignmentthree

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentthree.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private var registeredName: String? = null
    private var registeredEmail: String? = null
    private var registeredPassword: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil data dari RegisterActivity jika ada
        registeredName = intent.getStringExtra("reg_name")
        registeredEmail = intent.getStringExtra("reg_email")
        registeredPassword = intent.getStringExtra("reg_password")

        binding.loginBtn.setOnClickListener {
            val inputName = binding.nameInput.text.toString()
            val inputEmail = binding.emailInput.text.toString()
            val inputPassword = binding.passwordInput.text.toString()

            if (inputName.isNotEmpty() && inputEmail.isNotEmpty() && inputPassword.isNotEmpty()) {
                if (inputName == registeredName && inputEmail == registeredEmail && inputPassword == registeredPassword) {
                    val user = User(inputName, inputEmail)
                    val intent = Intent(this, LandingActivity::class.java)
                    intent.putExtra("user_data", user)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "Invalid credentials. Please register first or check your input.", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.registerBtn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}
