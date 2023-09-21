package com.jaehee.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jaehee.ecommerceappkotlin.databinding.ActivityDownloadingImageBinding
import com.squareup.picasso.Picasso

private lateinit var binding: ActivityDownloadingImageBinding
class DownloadingImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDownloadingImageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnDownloadImage.setOnClickListener {
            val imageURL = "http://61.109.169.174//smartphone.png"
            //download libray - picasso library

            Picasso.get().load(imageURL).into(binding.imgDownloadedImage);
        }

    }
}