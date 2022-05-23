package com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company

import com.nihad.cleanarchitecture.feature_name.domain.model.Company

data class CompanyDetailsDTO(
    val code: Int,
    val `data`: List<Data>,
    val status: String,
    val total: Int
)

fun CompanyDetailsDTO.toCompany(): List<Company> {

    return data.map {

        Company(
            address = it.addresses.map { address ->
                "${address.buildingNumber}, ${address.streetName}, ${address.street}, ${address.city}, ${address.country},${address.zipcode}"
            },
            contact = it.contact.phone,
            country = it.country,
            email = it.email,
            id = it.id,
            image = it.image,
            name = it.name,
            phone = it.phone,
            website = it.website
        )

    }
}

fun getAddress(addresses: List<Addresse>): List<String> {
    val address = mutableListOf<String>()
    addresses.forEach {
        it.apply {
            address.add("$buildingNumber, $streetName, $street, $city, $country,$zipcode")
        }
    }
    return address


}
