package com.kalamou.jcdecauxtest.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AvailabilitiesX(
    @SerialName("bikes")
    val bikes: Int,
    @SerialName("electricalBikes")
    val electricalBikes: Int,
    @SerialName("electricalInternalBatteryBikes")
    val electricalInternalBatteryBikes: Int,
    @SerialName("electricalRemovableBatteryBikes")
    val electricalRemovableBatteryBikes: Int,
    @SerialName("mechanicalBikes")
    val mechanicalBikes: Int,
    @SerialName("stands")
    val stands: Int
)