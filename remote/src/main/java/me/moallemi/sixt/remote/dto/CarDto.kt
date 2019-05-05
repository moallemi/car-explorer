package me.moallemi.sixt.remote.dto

import com.google.gson.annotations.SerializedName

data class CarDto(
    @SerializedName("carImageUrl") val carImageUrl: String?,
    @SerializedName("color") val color: String?,
    @SerializedName("fuelLevel") val fuelLevel: Double?,
    @SerializedName("fuelType") val fuelType: String?,
    @SerializedName("group") val group: String?,
    @SerializedName("id") val id: String?,
    @SerializedName("innerCleanliness") val innerCleanliness: String?,
    @SerializedName("latitude") val latitude: Double?,
    @SerializedName("licensePlate") val licensePlate: String?,
    @SerializedName("longitude") val longitude: Double?,
    @SerializedName("make") val make: String?,
    @SerializedName("modelIdentifier") val modelIdentifier: String?,
    @SerializedName("modelName") val modelName: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("series") val series: String?,
    @SerializedName("transmission") val transmission: String?
)