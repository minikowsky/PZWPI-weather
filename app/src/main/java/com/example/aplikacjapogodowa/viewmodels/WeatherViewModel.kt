package com.example.aplikacjapogodowa.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aplikacjapogodowa.model.WeatherAPIResponse
import com.example.aplikacjapogodowa.network.WeatherRepository
import kotlinx.coroutines.launch

private const val DEFAULT_CITY: String = "GLIWICE"

class WeatherViewModel : ViewModel() {
    private val _weather: MutableLiveData<WeatherAPIResponse> = MutableLiveData()
    val weather: LiveData<WeatherAPIResponse>
        get() {
            return _weather
        }

    fun getWeather(unit: String, city: String = DEFAULT_CITY) {
        viewModelScope.launch {
            val w = WeatherRepository.get(unit, city)
            if(w != null) {
                _weather.value = w
            }
        }
    }

    fun getWeatherByLocation(unit: String, latitude: Double?, longitude: Double?) {
        if(latitude == null || longitude == null) {
            getWeather(unit)
        }

        viewModelScope.launch {
            val w = WeatherRepository.getByLocation(unit, latitude.toString(), longitude.toString())
            if(w != null) {
                _weather.value = w
            }
        }
    }
}