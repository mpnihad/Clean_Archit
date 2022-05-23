package com.nihad.cleanarchitecture.feature_name.presentation.book_name.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nihad.cleanarchitecture.feature_name.presentation.activityname.BookViewModel
import com.nihad.cleanarchitecture.feature_name.presentation.activityname.CompanyViewModel

@Composable
fun BookListScreen(
    navController: NavController,
    viewModel:BookViewModel= hiltViewModel()
) {

    val state=viewModel.state.value
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        itemsIndexed(state.bookList){ index,book->

            Text("$index ${book.title}")

        }
    }




}