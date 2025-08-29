package com.test.weatherappliaction.design.spalsh
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.TextUtils
import android.util.Log
import com.test.weatherappliaction.R
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.test.weatherappliaction.databinding.SplashActivityBinding
import com.test.weatherappliaction.design.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {


   // private val splashViewModel by viewModels<SplashViewModel>()
    private lateinit var binding: SplashActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.splash_activity)
        Handler(Looper.getMainLooper()).postDelayed({
                val homeScreen = Intent(this, HomeActivity::class.java)
                startActivity(homeScreen)

        }, 2500)

    }




}