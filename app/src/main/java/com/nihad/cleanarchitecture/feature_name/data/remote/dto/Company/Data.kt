package com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company

data class Data(
    val addresses: List<Addresse>,
    val contact: Contact,
    val country: String,
    val email: String,
    val id: Int,
    val image: String,
    val name: String,
    val phone: String,
    val vat: String,
    val website: String
)