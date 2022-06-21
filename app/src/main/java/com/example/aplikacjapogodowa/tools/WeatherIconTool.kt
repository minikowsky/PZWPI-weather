package com.example.aplikacjapogodowa.tools

import com.example.aplikacjapogodowa.R

class WeatherIconTool {
    companion object {
        //simple function that maps code to icon id
        fun getMipmapId(code: String): Int {
            return when (code) {
                "01d", "01n" -> R.mipmap.sun
                "02d", "02n" -> R.mipmap.partly_cloudy_day
                "03d", "03n" -> R.mipmap.clouds
                "04d", "04n" -> R.mipmap.cloud
                "09d", "09n" -> R.mipmap.moderate_rain
                "10d", "10n" -> R.mipmap.rainfall
                "11d", "11n" -> R.mipmap.cloud_lightning
                "13d", "13n" -> R.mipmap.snow
                "50d", "50n" -> R.mipmap.haze
                else -> R.mipmap.sun
            }
        }
    }
}