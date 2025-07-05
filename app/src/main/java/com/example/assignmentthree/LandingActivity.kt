package com.example.assignmentthree

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.assignmentthree.databinding.ActivityLandingBinding

class LandingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLandingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLandingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val user = intent.getParcelableExtra<User>("user_data")
        binding.welcomeText.text = "Welcome, ${user?.name}!"
    }
}
