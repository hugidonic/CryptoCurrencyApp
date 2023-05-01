package com.hugidonic.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiFactory {

    val paprikaApi: CoinPaprikaApi = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(CoinPaprikaApi::class.java)

    companion object {
        const val BASE_URL = "https://api.coinpaprika.com"
    }
}