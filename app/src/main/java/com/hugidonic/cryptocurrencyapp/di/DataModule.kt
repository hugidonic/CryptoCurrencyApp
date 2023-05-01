package com.hugidonic.cryptocurrencyapp.di

import com.hugidonic.data.remote.ApiFactory
import com.hugidonic.data.remote.CoinPaprikaApi
import com.hugidonic.data.repository.CoinRepositoryImpl
import com.hugidonic.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideCoinApi(): CoinPaprikaApi {
        return ApiFactory().paprikaApi
    }

    @Provides
    @Singleton
    fun provideCoinRepository(coinPaprikaApi: CoinPaprikaApi): CoinRepository {
        return CoinRepositoryImpl(
            api = coinPaprikaApi
        )
    }
}