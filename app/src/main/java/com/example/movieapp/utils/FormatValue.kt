package com.example.movieapp.utils

import kotlin.math.pow
import kotlin.math.round

object FormatValue {

    fun Double?.toDecimalValue(decimalPlaces: Int = 2): Double {
        val factor = 10.0.pow(decimalPlaces.toDouble())
        return round((this ?: 0.0 ) * factor) / factor
    }
}