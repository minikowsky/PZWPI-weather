package com.example.aplikacjapogodowa.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val WEATHER_API_URL = "https://api.openweathermap.org/data/2.5/"

object RetrofitInstance {

    //retrofit instance with base url
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(WEATHER_API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    //api instance of retrofit instance
    val api: WeatherAPI by lazy {
        retrofit.create(WeatherAPI::class.java)
    }
}