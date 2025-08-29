package com.test.weatherappliaction.data.remote

import com.test.weatherappliaction.model.BaseApiResponse
import com.test.weatherappliaction.model.WeatherData
import com.test.weatherappliaction.util.NetworkResult
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@ActivityRetainedScoped
class WeatherRepository @Inject constructor(
    private val remoteDataSource: WeatherDataSource) : BaseApiResponse() {

    suspend fun getWeatherData(
        lat: Double?,
        long: Double?,
    ): Flow<NetworkResult<WeatherData>> {
        return flow {
            emit(safeApiCall { remoteDataSource.getWeatherData(lat,long) })
        }.flowOn(Dispatchers.IO)
    }
}