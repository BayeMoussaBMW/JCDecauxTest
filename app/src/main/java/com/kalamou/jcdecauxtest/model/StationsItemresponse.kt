package com.kalamou.jcdecauxtest.model

import kotlinx.serialization.SerialName

class StationsItemresponse(
    @SerialName("number")
    val number: Int,
    @SerialName("name")
    val name: String,
    @SerialName("address")
    val address: String,
    @SerialName("position")
    val latitude: Double,
    @SerialName("shape")
    val longitude: Double
) {
    data class Geometry(
        val location: GeometryLocation
    )

    data class GeometryLocation(
        val lat: Double,
        val lng: Double
    )
}

fun StationsItemresponse.toStationItem(): StationsItem = StationsItem(

    number = number,
    name = name,
    address = address,
    latitude = latitude,
    longitude = longitude
)