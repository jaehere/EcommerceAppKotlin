package com.jaehee.ecommerceappkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
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
            val productURL = "http://61.109.169.174/Ecommerce/present_json.php?" +
                    "id=${binding.edtProductID.text.toString()}"
            val requestQ: RequestQueue = Volley.newRequestQueue(this@ShowJsonObjectActivity)
            val jsonOR = JsonObjectRequest(Request.Method.GET, productURL, null,
                Response.Listener { response ->
                    binding.txtProductName.text = response.getString("name")
                    binding.txtProductPrice.text = response.getString("price")
                }, Response.ErrorListener { error ->
                    binding.txtProductName.text = error.message
                }
            )
            requestQ.add(jsonOR)
        }

    }
}