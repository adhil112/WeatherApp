package com.test.weatherappliaction.data.remote

import javax.inject.Inject

class WeatherDataSource @Inject constructor(private val weatherApi: WeatherApi) {

    suspend fun getWeatherData(
        lat: Double?,
        long: Double?,
    ) =
        weatherApi.getWeatherData(lat,long)
}