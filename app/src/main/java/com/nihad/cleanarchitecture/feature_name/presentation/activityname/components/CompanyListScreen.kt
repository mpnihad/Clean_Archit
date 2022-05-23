package com.nihad.cleanarchitecture.feature_name.presentation.activityname.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.nihad.cleanarchitecture.feature_name.presentation.activityname.CompanyViewModel

@Composable
fun CompanyListScreen(
    navController: NavController,
    viewModel:CompanyViewModel = hiltViewModel()
) {

    val state=viewModel.state.value
    LazyColumn(modifier = Modifier.fillMaxWidth()){
        items(state.companyList){ company->

            Text(company.name)

        }
    }




}