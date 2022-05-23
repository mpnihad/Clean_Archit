package com.nihad.cleanarchitecture.feature_name.domain.use_case.get_company

import com.nihad.cleanarchitecture.core.Resource
import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company.toCompany
import com.nihad.cleanarchitecture.feature_name.domain.model.Company
import com.nihad.cleanarchitecture.feature_name.domain.repository.CompanyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCompanyUseCase @Inject constructor(
    private val repository: CompanyRepository
) {
    //only one functionality


    operator fun invoke(numberOfCompany:Int): Flow<Resource<List<Company>>> = flow<Resource<List<Company>>>{

        try {

            emit(Resource.Loading())
            val company = repository.getCountry(numberOfCompany).toCompany()
            emit(Resource.Success(company))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error Occured"))
        }


    }

}