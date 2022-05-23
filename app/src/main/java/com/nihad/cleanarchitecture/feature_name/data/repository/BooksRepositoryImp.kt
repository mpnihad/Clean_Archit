package com.nihad.cleanarchitecture.feature_name.data.repository

import com.nihad.cleanarchitecture.feature_name.data.remote.ServiceClass
import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Books.BooksDetailsDTO
import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company.CompanyDetailsDTO
import com.nihad.cleanarchitecture.feature_name.domain.model.Company
import com.nihad.cleanarchitecture.feature_name.domain.repository.BooksRepository
import com.nihad.cleanarchitecture.feature_name.domain.repository.CompanyRepository
import javax.inject.Inject

class BooksRepositoryImp @Inject constructor(
    private  val api:ServiceClass
) :BooksRepository{
    override suspend fun getBooks(count: Int):BooksDetailsDTO {
        return api.getBooksDetails(count = count)
    }
}