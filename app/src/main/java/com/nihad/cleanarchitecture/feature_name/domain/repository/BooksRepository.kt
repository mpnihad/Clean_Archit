package com.nihad.cleanarchitecture.feature_name.domain.repository

import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Books.BooksDetailsDTO
import com.nihad.cleanarchitecture.feature_name.domain.model.Books

interface BooksRepository {

    suspend fun getBooks(count:Int):BooksDetailsDTO
}