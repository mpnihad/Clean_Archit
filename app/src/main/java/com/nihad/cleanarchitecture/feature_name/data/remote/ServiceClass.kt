package com.nihad.cleanarchitecture.feature_name.data.remote

import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Books.BooksDetailsDTO
import com.nihad.cleanarchitecture.feature_name.data.remote.dto.Company.CompanyDetailsDTO
import retrofit2.http.GET
import retrofit2.http.Query

interface ServiceClass {

    @GET("v1/companies")
    suspend fun getCompanyDetails(
        @Query("_quantity") count:Int
    ): CompanyDetailsDTO

    @GET("v1/books")
    suspend fun getBooksDetails(
        @Query("_quantity") count:Int
    ):BooksDetailsDTO
}