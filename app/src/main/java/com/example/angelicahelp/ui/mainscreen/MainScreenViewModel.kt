package com.example.angelicahelp.ui.mainscreen

import androidx.lifecycle.ViewModel
import java.lang.Math.PI
import java.util.Random
import kotlin.math.ln

class MainScreenViewModel : ViewModel() {
    var mean: Double? = null
    var variance: Double? = null
    var randomNumber: Double? = null

    private val random = Random()

    fun getResult(): Double? {
        if (mean == null || variance == null)
            randomNumber = null
        else if (mean!! > 0 && variance!! >= 0)
            randomNumber = generateLogNormal(mean!!, variance!!, 1.0)
        return randomNumber
    }

    private fun generateLogNormal(mu: Double, sigmaSquared: Double, multiplier: Double): Double {
        val modifiedSigmaSquared = sigmaSquared * multiplier
        val u1 = random.nextDouble()
        val u2 = random.nextDouble()
        val z = kotlin.math.sqrt(-2.0 * ln(u1)) * kotlin.math.cos(2.0 * PI * u2)
        return kotlin.math.exp(mu + kotlin.math.sqrt(modifiedSigmaSquared) * z)
    }

}
