package com.hugidonic.domain.usecases

import com.hugidonic.domain.entities.CoinDetailsModel
import com.hugidonic.domain.entities.Resource
import com.hugidonic.domain.repository.CoinRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class GetCoinDetailsUseCase(private val coinRepository: CoinRepository) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetailsModel>> = flow {
        try {
            emit(Resource.Loading())
            val coinDetails = coinRepository.getCoinDetailsById(coinId=coinId)
            emit(Resource.Success(data=coinDetails))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}