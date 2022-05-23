package com.nihad.cleanarchitecture.feature_name.presentation.activityname

import com.nihad.cleanarchitecture.feature_name.domain.model.Company

data class CompanyState(
    val isLoading : Boolean=false,
    val companyList:List<Company> = emptyList(),
    val error:String = ""
)
