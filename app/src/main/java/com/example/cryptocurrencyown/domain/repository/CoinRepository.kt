package com.example.cryptocurrencyown.domain.repository

import com.example.cryptocurrencyown.data.remote.dto.CoinDetailDto
import com.example.cryptocurrencyown.data.remote.dto.CoinDto

interface CoinRepository {

    suspend fun getCoins(): List<CoinDto>

    suspend fun getCoinById(coinId: String): CoinDetailDto
}