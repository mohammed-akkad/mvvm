package com.example.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.example.mvvm.databinding.ActivityMainBinding
import com.example.mvvm.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
     private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addCallBacks()
    }

    private fun addCallBacks() {
        binding.buttonGetName.setOnClickListener {
            viewModel.getUserName()
        }
        viewModel.currentUser.observe(this,{
            binding.textViewName.text = it
        })
    }

}