package com.hugidonic.data.repository

import com.hugidonic.data.remote.CoinPaprikaApi
import com.hugidonic.data.remote.dto.toCoinDetailModel
import com.hugidonic.data.remote.dto.toCoinModel
import com.hugidonic.domain.entities.CoinDetailsModel
import com.hugidonic.domain.entities.CoinModel
import com.hugidonic.domain.repository.CoinRepository

class CoinRepositoryImpl(
    private val api: CoinPaprikaApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinModel> {
        return api.getCoins().map {
            it.toCoinModel()
        }
    }

    override suspend fun getCoinDetailsById(coinId: String): CoinDetailsModel {
        return api.getCoinDetails(coinId).toCoinDetailModel()
    }
}