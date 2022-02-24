package com.kalamou.jcdecauxtest.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TotalStands(
    @SerialName("availabilities")
    val availabilities: AvailabilitiesXX,
    @SerialName("capacity")
    val capacity: Int
)