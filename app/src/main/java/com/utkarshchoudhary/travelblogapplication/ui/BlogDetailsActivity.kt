package com.utkarshchoudhary.travelblogapplication.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.utkarshchoudhary.travelblogapplication.R
import com.utkarshchoudhary.travelblogapplication.data.BlogHttpClient
import com.utkarshchoudhary.travelblogapplication.data.Data
import com.utkarshchoudhary.travelblogapplication.databinding.ActivityBlogDetailsBinding

private const val IMAGE_URL = "https://bitbucket.org/dmytrodanylyk/travel-blog-resources/raw/" +
        "3436e16367c8ec2312a0644bebd2694d484eb047/images/sydney_image.jpg"
private const val AVATAR_URL = "https://bitbucket.org/dmytrodanylyk/travel-blog-resources/raw/" +
        "3436e16367c8ec2312a0644bebd2694d484eb047/avatars/avatar1.jpg"

class BlogDetailsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityBlogDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBlogDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageBack.setOnClickListener { finish() }

        loadData()
    }

    private fun loadData() {
        BlogHttpClient.loadBlogArticles(
            onSuccess = { list: List<Data> ->
                runOnUiThread { showData(list[0]) }
            },
            onError = {
                // handle error
            }
        )
    }

    private fun showData(blog: Data) {
        binding.textTitle.text = blog.title
        binding.textDate.text = blog.date
        binding.textAuthor.text = blog.author.name
        binding.textRating.text = blog.rating.toString()
        binding.textViews.text = String.format("(%d views)", blog.views)
        binding.textDescription.text = blog.description
        binding.ratingBar.rating = blog.rating

        Glide.with(this)
            .load(blog.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imageMain)
        Glide.with(this)
            .load(blog.author.avatar)
            .transform(CircleCrop())
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(binding.imageAvatar)

    }
}