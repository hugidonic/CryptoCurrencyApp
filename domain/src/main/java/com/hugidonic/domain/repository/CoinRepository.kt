package com.hugidonic.domain.repository

import com.hugidonic.domain.entities.CoinDetailsModel
import com.hugidonic.domain.entities.CoinModel

interface CoinRepository {
    suspend fun getCoins(): List<CoinModel>

    suspend fun getCoinDetailsById(coinId: String): CoinDetailsModel
}