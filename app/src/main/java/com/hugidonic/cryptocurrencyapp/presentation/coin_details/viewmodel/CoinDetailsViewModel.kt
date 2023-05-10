package com.hugidonic.cryptocurrencyapp.presentation.coin_details.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hugidonic.cryptocurrencyapp.presentation.coin_details.state.CoinDetailsState
import com.hugidonic.cryptocurrencyapp.presentation.coin_list.state.CoinListState
import com.hugidonic.domain.entities.Resource
import com.hugidonic.domain.usecases.GetCoinDetailsUseCase
import com.hugidonic.domain.usecases.GetCoinsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailsViewModel @Inject constructor(
    private val getCoinDetailsUseCase: GetCoinDetailsUseCase,
    private val savedStateHandle: SavedStateHandle
): ViewModel() {

    private val _state = mutableStateOf(CoinDetailsState())
    val state: State<CoinDetailsState> = _state

    init {
        savedStateHandle.get<String>(PARAM_COIN_ID)?.let { coinId ->
            getCoinDetails(coinId = coinId)
        }
    }

    private fun getCoinDetails(coinId: String) {
        getCoinDetailsUseCase(coinId).onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _state.value = CoinDetailsState(coinDetails=result.data)
                }
                is Resource.Error -> {
                    _state.value = CoinDetailsState(error=result.message ?: "Unexpected error")
                }
                is Resource.Loading -> {
                    _state.value = CoinDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    companion object {
        const val PARAM_COIN_ID = "coinId"
    }

}