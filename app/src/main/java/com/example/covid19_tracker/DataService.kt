package com.example.covid19_tracker

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://data.covid19india.org/"

interface dataInterface {


    @GET("data.json")
    fun getstatedata(): Call<Data>


}

object dataservice {
    val datainstance: dataInterface

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        datainstance = retrofit.create(dataInterface::class.java)

    }

}