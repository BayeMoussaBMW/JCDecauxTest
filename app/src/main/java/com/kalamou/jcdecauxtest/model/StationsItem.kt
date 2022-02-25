package com.kalamou.jcdecauxtest.model

import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.clustering.ClusterItem
import kotlinx.serialization.SerialName


data class StationsItem(
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

): ClusterItem {

    override fun getPosition(): LatLng =
        latitude as LatLng

    override fun getTitle(): String =
        name

    override fun getSnippet(): String =
        address
}

