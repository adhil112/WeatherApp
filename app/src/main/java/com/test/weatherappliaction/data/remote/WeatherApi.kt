package com.test.weatherappliaction.data.remote

import com.test.weatherappliaction.model.WeatherData
import com.test.weatherappliaction.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface WeatherApi {

    @GET(value = "data/2.5/forecast")
    suspend fun getWeatherData(
        @Query("lat") lat: Double?,
        @Query("lon") lon: Double?,
        @Query("units") units: String = "metric",
        @Query("appid") appid: String = Constants.API_KEY
    ): Response<WeatherData>
}