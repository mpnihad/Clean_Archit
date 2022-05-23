package com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company

data class Addresse(
    val buildingNumber: String,
    val city: String,
    val country: String,
    val county_code: String,
    val id: Int,
    val latitude: Double,
    val longitude: Double,
    val street: String,
    val streetName: String,
    val zipcode: String
)