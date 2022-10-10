package com.utkarshchoudhary.travelblogapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.utkarshchoudhary.travelblogapplication.R
import com.utkarshchoudhary.travelblogapplication.databinding.ActivityBlogDetailsBinding

class BlogDetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBlogDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}