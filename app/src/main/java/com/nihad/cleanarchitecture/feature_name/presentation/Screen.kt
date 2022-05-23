package com.nihad.cleanarchitecture.feature_name.presentation

sealed class Screen(val route:String){
    object CompanyListScreen:Screen("company_list_screen")
    object BookListScreen:Screen("book_list_screen")

}
