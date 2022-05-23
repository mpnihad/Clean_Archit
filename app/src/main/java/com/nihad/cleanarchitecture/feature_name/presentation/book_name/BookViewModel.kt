package com.nihad.cleanarchitecture.feature_name.presentation.activityname

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nihad.cleanarchitecture.core.Resource
import com.nihad.cleanarchitecture.feature_name.domain.use_case.get_books.GetBooksUseCase
import com.nihad.cleanarchitecture.feature_name.domain.use_case.get_company.GetCompanyUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BookViewModel @Inject constructor(
    private val getBooksUseCase: GetBooksUseCase
):ViewModel() {

    private val _state = mutableStateOf(BookState())
    val state:State<BookState> = _state

    init {

        getBooks(100)
    }
    private fun getBooks(count:Int){
        getBooksUseCase(count).onEach {  result ->
            when(result){
                is Resource.Success ->{
                    _state.value=BookState(
                         bookList = result.data?: emptyList(),

                    )
                }
                is Resource.Error -> {
                    _state.value=BookState(
                    error=result.message?:"An UnExpected error Occured")
                }
                is Resource.Loading ->{
                    _state.value=BookState(
                        isLoading = true
                    )
                }
             }
        }.launchIn(viewModelScope)
    }
}