package com.nihad.cleanarchitecture.feature_name.domain.model

import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company.Addresse
import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company.Contact

data class Company(
    val address: List<String>,
    val contact: String,
    val country: String,
    val email: String,
    val id: Int,
    val image: String,
    val name: String,
    val phone: String,
    val website: String
)
