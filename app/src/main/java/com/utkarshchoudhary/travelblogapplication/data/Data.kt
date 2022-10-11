package com.utkarshchoudhary.travelblogapplication.data

data class Data(
    val author: Author,
    val date: String,
    val description: String,
    val image: String,
    val rating: Float,
    val title: String,
    val views: Int
)