package com.example.angelicahelp.ui.mainscreen

import androidx.lifecycle.ViewModel
import org.apache.commons.math3.distribution.LogNormalDistribution

class MainScreenViewModel : ViewModel() {
    var mean_val: Double? = null
    var variance_val: Double? = null
    var random_number_result: Double? = null

    fun getResult(): Double? {
        if (mean_val != null && variance_val != null) {
            random_number_result = LogNormalDistribution(
                mean_val!!,
                kotlin.math.sqrt(variance_val!!),
                0.8
            ).sample()
        } else return null
        return random_number_result
    }


}