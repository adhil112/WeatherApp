package com.test.weatherappliaction.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.test.weatherappliaction.R
import com.test.weatherappliaction.databinding.RvWeatherInfoBinding
import com.test.weatherappliaction.model.Item0

class WeatherDataAdapter(

    private val weatherListData : List<Item0>
): RecyclerView.Adapter<WeatherDataAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherDataAdapter.ViewHolder {
        val binding = RvWeatherInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WeatherDataAdapter.ViewHolder, position: Int) {
        val weatherListData = weatherListData[position]

        holder.binding.tvWeek.text = weatherListData.weather.get(position).main

        holder.binding.tvMonth.text = weatherListData.dt_txt

        holder.binding.tvTemp.text = weatherListData.main.temp.toString()
        val icon = weatherListData.weather[0].icon
        val imageRes = when (icon) {
            "01d" -> R.drawable.sunny
            "02d" -> R.drawable.sunny
            "03d", "04d", "04n", "03n", "02n" -> R.drawable.cloudy
            "09d", "10n", "09n" -> R.drawable.rainy
            "10d" -> R.drawable.rainy_sunny
            "11d", "11n" -> R.drawable.thunder_lightning
            "13d", "13n" -> R.drawable.snow
            "50d", "50n" -> R.drawable.fog
            "01n" -> R.drawable.clear
            else -> R.drawable.cloudy
        }

        holder.binding.ivWeather.setImageResource(imageRes)


    }

    inner class ViewHolder(val binding: RvWeatherInfoBinding) : RecyclerView.ViewHolder(binding.root)
    override fun getItemCount(): Int {
        return weatherListData.size
    }
}