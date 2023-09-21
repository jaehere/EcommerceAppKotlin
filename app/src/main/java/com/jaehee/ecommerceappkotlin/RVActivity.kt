package com.jaehee.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jaehee.ecommerceappkotlin.databinding.ActivityRvactivityBinding

private lateinit var binding: ActivityRvactivityBinding
class RVActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRvactivityBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }
}