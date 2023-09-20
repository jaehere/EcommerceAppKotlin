package com.jaehee.ecommerceappkotlin

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jaehee.ecommerceappkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var sharedP: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        /*binding.largeRadioButton.setOnClickListener {
            binding.textView.textSize = 50f
        }
        binding.mediumRadioButton.setOnClickListener {
            binding.textView.textSize = 20f
        }
        binding.smallRadioButton.setOnClickListener {
            binding.textView.textSize = 10f
        }
        */

        binding.btnAdd.setOnClickListener{
            sharedP = getSharedPreferences("addData", Context.MODE_PRIVATE)
            var myEditor = sharedP?.edit()
            myEditor?.putString("product_name", binding.edtProduct.text.toString())
            myEditor?.commit() // data 저장
            Toast.makeText(this@MainActivity, "The Product is Saved", Toast.LENGTH_SHORT).show()
        }

        binding.btnGetProduct.setOnClickListener{
            binding.txtGetProduct.text = sharedP?.getString("product_name", "nothing")
        }

    }
}

