package com.example.angelicahelp.ui.mainscreen

import androidx.lifecycle.ViewModel
import org.apache.commons.math3.distribution.LogNormalDistribution

class MainScreenViewModel : ViewModel() {
    var mean: Double? = null
    var variance: Double? = null
    var randomNumber: Double? = null

    private val coefficient = 0.8

    fun getResult(): Double? {
        if (mean != null && variance != null) {
            randomNumber = LogNormalDistribution(
                mean!!,
                kotlin.math.sqrt(variance!!),
                coefficient
            ).sample()
        } else return null
        return randomNumber
    }


}
