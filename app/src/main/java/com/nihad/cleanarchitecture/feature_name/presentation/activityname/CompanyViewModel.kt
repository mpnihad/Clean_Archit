package com.nihad.cleanarchitecture.feature_name.presentation.activityname

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nihad.cleanarchitecture.core.Constant.CONST_COUNT_COMPANT
import com.nihad.cleanarchitecture.core.Resource
import com.nihad.cleanarchitecture.feature_name.domain.use_case.get_company.GetCompanyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CompanyViewModel @Inject constructor(
    private  val getCompanyUseCase: GetCompanyUseCase,
    private val savedStateHandle:SavedStateHandle
):ViewModel() {

    private val _state = mutableStateOf(CompanyState())
    val state:State<CompanyState> = _state

    init {

        getCompany()
    }
    private fun getCompany(){

//        savedStateHandle.get<Int>(CONST_COUNT_COMPANT)?.let{ count->
        getCompanyUseCase(100).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CompanyState(
                        companyList = result.data ?: emptyList(),

                        )
                }
                is Resource.Error -> {
                    _state.value = CompanyState(
                        error = result.message ?: "An UnExpected error Occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = CompanyState(
                        isLoading = true
                    )
                }
            }
        }.launchIn(viewModelScope)
//        }
    }
}