package com.kalamou.jcdecauxtest.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OverflowStands(
    @SerialName("availabilities")
    val availabilities: AvailabilitiesX,
    @SerialName("capacity")
    val capacity: Int
)