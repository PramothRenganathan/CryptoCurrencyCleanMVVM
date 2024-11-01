package com.example.cryptocurrencyown.data.remote

import com.example.cryptocurrencyown.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyown.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaAPI {

    @GET("/v1/coins")
    suspend fun getCoins(): List<CoinDto>

    @GET("/v1/coins/{coinId}")
    suspend fun getCoinById(@Path("coinId") coinId: String): CoinDetailDto
}