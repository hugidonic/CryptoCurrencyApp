package com.hugidonic.cryptocurrencyapp.presentation.coin_list.state

import com.hugidonic.domain.entities.CoinModel

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<CoinModel> = emptyList(),
    val error: String = "",
)