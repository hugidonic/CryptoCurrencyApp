package com.hugidonic.domain.usecases

import com.hugidonic.domain.entities.CoinModel
import com.hugidonic.domain.entities.Resource
import com.hugidonic.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinsUseCase(private val coinRepository: CoinRepository) {
    suspend operator fun invoke(): Flow<Resource<List<CoinModel>>> = flow {
        try {
            emit(Resource.Loading())

            val coins = coinRepository.getCoins()
            emit(Resource.Success(data=coins))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}