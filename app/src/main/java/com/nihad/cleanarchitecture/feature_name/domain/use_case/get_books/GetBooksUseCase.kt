package com.nihad.cleanarchitecture.feature_name.domain.use_case.get_books

import com.nihad.cleanarchitecture.core.Resource
import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Books.toBooks
import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company.toCompany
import com.nihad.cleanarchitecture.feature_name.domain.model.Books
import com.nihad.cleanarchitecture.feature_name.domain.model.Company
import com.nihad.cleanarchitecture.feature_name.domain.repository.BooksRepository
import com.nihad.cleanarchitecture.feature_name.domain.repository.CompanyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(
    private val repository: BooksRepository
) {
    //only one functionality


    operator fun invoke(numberOfBooks:Int): Flow<Resource<List<Books>>> = flow<Resource<List<Books>>>{

        try {

            emit(Resource.Loading())
            val company = repository.getBooks(numberOfBooks).toBooks()
            emit(Resource.Success(company))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: "Unexpected error Occured"))
        }


    }

}