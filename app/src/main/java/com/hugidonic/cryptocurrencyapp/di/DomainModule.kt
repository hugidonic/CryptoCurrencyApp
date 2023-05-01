package com.hugidonic.cryptocurrencyapp.di

import com.hugidonic.domain.repository.CoinRepository
import com.hugidonic.domain.usecases.GetCoinDetailsUseCase
import com.hugidonic.domain.usecases.GetCoinsUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideGetCoinsUseCase(coinRepository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(coinRepository=coinRepository)
    }

    @Provides
    fun provideGetCoinDetailsUseCase(coinRepository: CoinRepository): GetCoinDetailsUseCase {
        return GetCoinDetailsUseCase(coinRepository=coinRepository)
    }

}