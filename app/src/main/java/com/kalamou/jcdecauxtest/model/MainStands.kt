package com.kalamou.jcdecauxtest.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MainStands(
    @SerialName("availabilities")
    val availabilities: Availabilities,
    @SerialName("capacity")
    val capacity: Int
)