package com.utkarshchoudhary.travelblogapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utkarshchoudhary.travelblogapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}