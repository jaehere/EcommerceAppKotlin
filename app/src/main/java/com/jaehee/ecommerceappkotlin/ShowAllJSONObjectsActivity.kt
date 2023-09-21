package com.jaehee.ecommerceappkotlin

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.jaehee.ecommerceappkotlin.databinding.ActivityShowAllJsonobjectsBinding
import com.jaehee.ecommerceappkotlin.databinding.ActivityShowJsonObjectBinding
import org.json.JSONArray

private lateinit var binding : ActivityShowAllJsonobjectsBinding
class ShowAllJSONObjectsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityShowAllJsonobjectsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtAllProducts.setBackgroundColor(Color.BLUE)
        binding.txtAllProducts.setTextColor(Color.WHITE)

        binding.txtAllProducts.setOnClickListener {
            val allProductURL = "http://61.109.169.174//Ecommerce/present_json_array.php"

            var allProductsString: String = ""

            val requestQ : RequestQueue = Volley.newRequestQueue(this@ShowAllJSONObjectsActivity)

            val jsonAR = JsonArrayRequest(Request.Method.GET, allProductURL, null,
                Response.Listener { response ->
                    //for(productIndex in 0..response.length() - 1 ){
                    for(productIndex in 0.until(response.length())){
//                        allProductsString += (response.getJSONObject(productIndex).getString("name") + " - "
//                                    + response.getJSONObject(productIndex).getInt("price"))

                        var pn = response.getJSONObject(productIndex).getString("name")
                        var pp = response.getJSONObject(productIndex).getInt("price")

                        allProductsString += "$pn - $pp\n"

                    }
                    binding.txtAllProducts.text = allProductsString

                }, Response.ErrorListener { error ->
                    binding.txtAllProducts.text = error.message

                })

            requestQ.add(jsonAR)

        }


    }
}