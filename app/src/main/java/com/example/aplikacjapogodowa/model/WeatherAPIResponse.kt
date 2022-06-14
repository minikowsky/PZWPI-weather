package com.example.aplikacjapogodowa.model

data class WeatherAPIResponse (
    val coord: Coordinates,
    val weather: List<Weather>,
    val base: String,
    val main: Main,
    val visibility: Long,
    val wind: Wind,
    val clouds: Clouds?,
    val rain: Rain?,
    val snow: Snow?,
    val dt: Long,
    val sys: Sys,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Int) {

    override fun toString(): String {
        return "coord = $coord \n" +
                "weather = $weather \n" +
                "base = $base \n" +
                "main = $main" +
                "visibility = $visibility \n" +
                "wind = $wind \n" +
                "clouds = $clouds \n" +
                "rain = $rain \n" +
                "snow = $snow \n" +
                "dt = $dt \n" +
                "sys = $sys \n" +
                "timezone = $timezone \n" +
                "id = $id \n" +
                "name = $name \n" +
                "cod = $cod"
    }
}