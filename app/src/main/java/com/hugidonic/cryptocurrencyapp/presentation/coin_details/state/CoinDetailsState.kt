package com.hugidonic.cryptocurrencyapp.presentation.coin_details.state

import com.hugidonic.domain.entities.CoinDetailsModel

data class CoinDetailsState(
    val isLoading: Boolean = false,
    val coinDetails: CoinDetailsModel? = null,
    val error: String = ""
)