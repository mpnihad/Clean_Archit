package com.nihad.cleanarchitecture.feature_name.data.repository

import com.nihad.cleanarchitecture.feature_name.data.remote.ServiceClass
import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company.CompanyDetailsDTO
import com.nihad.cleanarchitecture.feature_name.domain.model.Company
import com.nihad.cleanarchitecture.feature_name.domain.repository.CompanyRepository
import javax.inject.Inject

class CompanyRepositoryImp @Inject constructor(
    private  val api:ServiceClass
) :CompanyRepository{
    override suspend fun getCountry(count: Int):CompanyDetailsDTO {
        return api.getCompanyDetails(count = count)
    }
}