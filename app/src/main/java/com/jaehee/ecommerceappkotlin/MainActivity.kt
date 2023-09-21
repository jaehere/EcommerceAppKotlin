package com.jaehee.ecommerceappkotlin

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.jaehee.ecommerceappkotlin.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var sharedP: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnGetData.setOnClickListener {
            val serverURL: String = "http://61.109.169.174/PHPTest/test_file.php"
            var requestQ: RequestQueue = Volley.newRequestQueue(this@MainActivity)
            //웹페이지에 있는 String text가져오기
            var stringRequest = StringRequest(Request.Method.GET, serverURL,
                Response.Listener { response ->

                    binding.txtHelloWorld.text = response

                }, Response.ErrorListener { error ->

                    binding.txtHelloWorld.text = error.message

                }
            )

            requestQ.add(stringRequest)


        }


    }
}

