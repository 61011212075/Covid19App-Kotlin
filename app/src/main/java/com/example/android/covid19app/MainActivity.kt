package com.example.android.covid19app

import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.animation.LinearInterpolator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.covid19app.adapter.ProvinceAdapter
import com.example.android.covid19app.services.repository.InfectionRepository
import com.example.android.covid19app.services.viewmodel.InfectionViewModel
import com.example.android.covid19app.services.viewmodel.InfectionViewModelFactory
import java.text.DecimalFormat
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    private lateinit var newCase: TextView
    private lateinit var totalCase: TextView
    private lateinit var recovered: TextView
    private lateinit var totalRecovered: TextView
    private lateinit var death: TextView
    private lateinit var totalDeath: TextView
    private lateinit var date: TextView

    private lateinit var infectionViewModel: InfectionViewModel

    private lateinit var  recyclerView: RecyclerView

    private var valueAnimator: ValueAnimator? = null

    private lateinit var dec:DecimalFormat


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Hide Appbar
        supportActionBar!!.hide()

        newCase = findViewById(R.id.new_cases)
        totalCase = findViewById(R.id.total_cases)
        recovered = findViewById(R.id.recovered)
        totalRecovered = findViewById(R.id.total_recovered)
        death = findViewById(R.id.death)
        totalDeath = findViewById(R.id.total_death)
        date = findViewById(R.id.date)

        // Formant Number
        dec = DecimalFormat("#,###.##")

        // Over all Infection
        val infectionRepository = InfectionRepository()
        val infectionViewModelFactory = InfectionViewModelFactory(infectionRepository)
        infectionViewModel = ViewModelProvider(this, infectionViewModelFactory)[InfectionViewModel::class.java]

        // Infection in each province
        fetchOverallInfection()

        recyclerView = findViewById(R.id.recycler_province)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchAllProvince()

    }

    @SuppressLint("SetTextI18n", "SimpleDateFormat")
    private fun  fetchOverallInfection(){
        infectionViewModel.getOverallInfection()
        infectionViewModel.listOverallInfection.observe(this) { response ->
            response.body()!!.forEach { data ->

                // Animation New Cases
                valueAnimator = ValueAnimator.ofInt(0, data.newCase).apply {
                    addUpdateListener {
                        newCase.text = "+${dec.format(it.animatedValue)} "
                    }
                    interpolator = LinearInterpolator()
                    duration = 1000
                    start()
                }

                // Animation Total Cases
                valueAnimator = ValueAnimator.ofInt(0, data.totalCase).apply {
                    addUpdateListener {
                        totalCase.text = "สะสม ${dec.format(it.animatedValue)}"
                    }
                    interpolator = LinearInterpolator()
                    duration = 1000
                    start()
                }

                // Animation New Recovered
                valueAnimator = ValueAnimator.ofInt(0, data.newRecovered).apply {
                    addUpdateListener {
                        recovered.text = "+${dec.format(it.animatedValue)} "
                    }
                    interpolator = LinearInterpolator()
                    duration = 1000
                    start()
                }

                // Animation Total Recovered
                valueAnimator = ValueAnimator.ofInt(0, data.totalRecovered).apply {
                    addUpdateListener {
                        totalRecovered.text = "สะสม ${dec.format(it.animatedValue)}"
                    }
                    interpolator = LinearInterpolator()
                    duration = 1000
                    start()
                }

                // Animation New Death
                valueAnimator = ValueAnimator.ofInt(0, data.newDeath).apply {
                    addUpdateListener {
                        death.text = "+${dec.format(it.animatedValue)} "
                    }
                    interpolator = LinearInterpolator()
                    duration = 1000
                    start()
                }

                // Animation Total Death
                valueAnimator = ValueAnimator.ofInt(0, data.totalDeath).apply {
                    addUpdateListener {
                        totalDeath.text = "สะสม ${dec.format(it.animatedValue)}"
                    }
                    interpolator = LinearInterpolator()
                    duration = 1000
                    start()
                }

                val parser = SimpleDateFormat("yyyy-MM-dd")
                val formatter = SimpleDateFormat("dd MMMM yyyy")
                date.text = formatter.format(parser.parse(data.date)!!)

            }
        }
    }

    private fun fetchAllProvince(){

        infectionViewModel.getProvinceInfection()
        infectionViewModel.listProvinceInfection.observe(this){ response ->

            // Sort by new case
            val provinceListNewCase = response.body()!!.sortedByDescending { it.newCase }

            recyclerView.adapter = ProvinceAdapter(provinceListNewCase)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        valueAnimator?.end()
        valueAnimator = null
    }


}