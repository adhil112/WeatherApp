package com.test.weatherappliaction.design.home

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Location
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.test.weatherappliaction.R
import com.test.weatherappliaction.adapters.WeatherDataAdapter
import com.test.weatherappliaction.databinding.HomeActivityBinding
import com.test.weatherappliaction.databinding.SplashActivityBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private val homeViewModel by viewModels<HomeViewModel>()

    private lateinit var binding: HomeActivityBinding
    lateinit var waterDataListAdapter: WeatherDataAdapter

    private lateinit var fusedLocationClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.home_activity)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        getLocationAndSetRecycler()
    }

    private fun getLocationAndSetRecycler() {
        if (ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                100
            )
            return
        }

        fusedLocationClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null) {
                val lat = location.latitude
                val long = location.longitude

                setRecyclerData(lat, long)
            } else {
                Toast.makeText(this, "Unable to fetch location", Toast.LENGTH_SHORT).show()
            }
        }
    }



    private fun setRecyclerData(lat: Double?, long: Double?) {
        homeViewModel.getWeatherList(lat, long)

        homeViewModel.weatherDataResp.observe(this) { data ->
            if (data != null) {
                binding.recyclerView.visibility = View.VISIBLE
                binding.recyclerView.layoutManager =
                    LinearLayoutManager(this, RecyclerView.VERTICAL, false)
                waterDataListAdapter = WeatherDataAdapter(data.list)
                binding.recyclerView.adapter = waterDataListAdapter
            } else {
                Log.e("Weather", "No data received")
            }
        }
    }
    }