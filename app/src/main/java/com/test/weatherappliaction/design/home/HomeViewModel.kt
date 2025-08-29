package com.test.weatherappliaction.design.home

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.weatherappliaction.data.remote.WeatherRepository
import com.test.weatherappliaction.model.Item0
import com.test.weatherappliaction.model.WeatherData
import com.test.weatherappliaction.util.NetworkResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: WeatherRepository) : ViewModel() {
    private val _weatherDataModelResponse = MutableLiveData<NetworkResult<WeatherData>?>()
    val weatherDataModelResponse: LiveData<NetworkResult<WeatherData>?> = _weatherDataModelResponse

    private val _weatherDataResp = MutableLiveData<WeatherData?>()
    val weatherDataResp: LiveData<WeatherData?> = _weatherDataResp

    fun getWeatherList(lat: Double?, long: Double?) = viewModelScope.launch {
        repository.getWeatherData(lat, long).collect { values ->
            _weatherDataModelResponse.value = values
            if (values is NetworkResult.Success) {
                _weatherDataResp.value = values.data
            }
        }
    }
}