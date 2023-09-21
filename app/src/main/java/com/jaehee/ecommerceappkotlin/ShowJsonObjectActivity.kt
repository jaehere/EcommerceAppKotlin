package com.jaehee.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jaehee.ecommerceappkotlin.databinding.ActivityMainBinding
import com.jaehee.ecommerceappkotlin.databinding.ActivityShowJsonObjectBinding

private lateinit var binding:ActivityShowJsonObjectBinding
class ShowJsonObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowJsonObjectBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSubmit.setOnClickListener {

        }

    }
}