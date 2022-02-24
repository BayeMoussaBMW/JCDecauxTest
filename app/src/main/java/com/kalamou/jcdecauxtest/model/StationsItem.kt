package com.kalamou.jcdecauxtest.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StationsItem(
    @SerialName("address")
    val address: String,
    @SerialName("banking")
    val banking: Boolean,
    @SerialName("bonus")
    val bonus: Boolean,
    @SerialName("connected")
    val connected: Boolean,
    @SerialName("contractName")
    val contractName: String,
    @SerialName("lastUpdate")
    val lastUpdate: String,
    @SerialName("mainStands")
    val mainStands: MainStands,
    @SerialName("name")
    val name: String,
    @SerialName("number")
    val number: Int,
    @SerialName("overflow")
    val overflow: Boolean,
    @SerialName("overflowStands")
    val overflowStands: OverflowStands,
    @SerialName("position")
    val position: Position,
    @SerialName("shape")
    val shape: Any,
    @SerialName("status")
    val status: String,
    @SerialName("totalStands")
    val totalStands: TotalStands
)