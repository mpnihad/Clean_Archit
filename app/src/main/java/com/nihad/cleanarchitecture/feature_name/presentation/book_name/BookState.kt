package com.nihad.cleanarchitecture.feature_name.presentation.activityname

import com.nihad.cleanarchitecture.feature_name.domain.model.Books
import com.nihad.cleanarchitecture.feature_name.domain.model.Company

data class BookState(
    val isLoading : Boolean=false,
    val bookList:List<Books> = emptyList(),
    val error:String = ""
)
