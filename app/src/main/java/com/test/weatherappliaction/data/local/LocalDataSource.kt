package com.test.weatherappliaction.data.local

import javax.inject.Inject

class LocalDataSource @Inject constructor(private val delivererDao: WeatherDao) {
}