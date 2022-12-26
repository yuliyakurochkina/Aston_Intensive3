package com.example.aston_intensive3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aston_intensive3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        with(binding) {
            btnTask1.setOnClickListener {
                startActivity(classOfActivity = Task1FlagsActivity::class.java)
            }
            btnTask2.setOnClickListener {
                startActivity(classOfActivity = Task2PicturesActivity::class.java)
            }
        }
    }
}