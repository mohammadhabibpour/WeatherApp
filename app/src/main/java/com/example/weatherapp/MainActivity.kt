package com.example.weatherapp

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.model.Weather
import com.example.weatherapp.viewmodel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    private lateinit var biding : ActivityMainBinding
    private val viewModel: WeatherViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        biding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(biding.root)


        viewModel.weatherResp.observe(this, {Weather->

            biding.apply {


                TempWt.text = Weather.temperature
                CityTxt.text = "Tehran"
                DesWt.text = Weather.description
                WindWt.text = Weather.wind

                val thursdayWeather = Weather.forecast[0]
                val fridyaWeather = Weather.forecast[0]
                val saturdayWeather = Weather.forecast[0]


                ThursDayWt.text = "${thursdayWeather.temperature} / ${thursdayWeather.wind}"
                FridayWt.text = "${fridyaWeather.temperature} / ${fridyaWeather.wind}"
                SaturdayWt.text = "${saturdayWeather.temperature} / ${saturdayWeather.wind}"


            }
        })


        }
}