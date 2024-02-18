package com.example.mpgcalculator.ui.theme

import kotlin.math.roundToInt

// ------ MPG to L100/km -----
fun mpgToKm(mpg: Double): Double {
    val result = 235.214583 / mpg
    return (result * 100.0).roundToInt() / 100.0
}

// ----- L/100km to MPG -----
fun kmToMpg(km: Double): Double {
    val result = 235.214583 / km
    return (result * 100.0).roundToInt() / 100.0
}