package com.example.covid19_tracker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var layoutManager: RecyclerView.LayoutManager? = null
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getdata()


    }

    private fun getdata() {
        val data: Call<Data> = dataservice.datainstance.getstatedata()
        data.enqueue(object : Callback<Data> {
            override fun onResponse(call: Call<Data>?, response: Response<Data>?) {
                val data = response?.body()
                if (data != null) {

                    val recyclerView: RecyclerView = findViewById(R.id.recycleview)

                    layoutManager = LinearLayoutManager(this@MainActivity)

                    recyclerView.layoutManager = layoutManager

                    adapter = RecyclerAdapter(this@MainActivity, data.statewise)
                    recyclerView.adapter = adapter
                    total1.text = data.statewise[0].confirmed
                    total2.text = data.statewise[0].active
                    total3.text = data.statewise[0].recovered
                    total4.text = data.statewise[0].deaths

                    Log.d("GOT", data.toString())
                }
            }

            override fun onFailure(call: Call<Data>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, "Error fetching data", Toast.LENGTH_SHORT).show()
            }
        })

    }
}