package com.hugidonic.cryptocurrencyapp.di

import com.hugidonic.domain.repository.CoinRepository
import com.hugidonic.domain.usecases.GetCoinDetailsUseCase
import com.hugidonic.domain.usecases.GetCoinsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
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