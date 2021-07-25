package com.example.searchitemsapp.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.searchitemsapp.R
import kotlinx.android.synthetic.main.activity_item_detail.*

class ItemDetailActivity : AppCompatActivity() {
    lateinit var img:String
    lateinit var  title :String
    lateinit var subTile :String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        getDataFromIntent()
        setDataToViews()
    }

    private fun getDataFromIntent() {
        val intent = Intent()
         img = intent.getStringExtra("image").toString()
        title = intent.getStringExtra("title").toString()
        subTile = intent.getStringExtra("subTitle").toString()
    }

    private fun setDataToViews() {
        tvTitle_Detail.text = subTile
        tvTitle_Detail.text = title
        Glide.with(ivItem_Detail).load(img).into(ivItem_Detail)
    }
}