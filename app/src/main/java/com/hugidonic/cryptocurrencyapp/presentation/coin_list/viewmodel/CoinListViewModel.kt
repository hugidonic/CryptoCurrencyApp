package com.hugidonic.cryptocurrencyapp.presentation.coin_list.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.cryptocurrencyapp.presentation.coin_list.state.CoinListState
import com.hugidonic.domain.entities.Resource
import com.hugidonic.domain.usecases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsUseCase: GetCoinsUseCase,
): ViewModel() {


    private val _state = mutableStateOf(CoinListState())
    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsUseCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins=result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(error=result.message ?: "Unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
                else -> {
                    _state.value = CoinListState(error=result.message ?: "Unexpected error")
                }
            }
        }.launchIn(viewModelScope)
    }

}