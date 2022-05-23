package com.nihad.cleanarchitecture.feature_name.domain.repository

import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company.CompanyDetailsDTO
import com.nihad.cleanarchitecture.feature_name.domain.model.Company

interface CompanyRepository {
    //if adding into Room we have this function herer



    suspend fun getCountry(count:Int):CompanyDetailsDTO
}