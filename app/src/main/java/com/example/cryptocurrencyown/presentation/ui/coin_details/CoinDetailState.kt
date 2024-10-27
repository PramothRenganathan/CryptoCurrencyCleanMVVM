package com.example.cryptocurrencyown.presentation.ui.coin_details

import com.example.cryptocurrencyown.common.Resource
import com.example.cryptocurrencyown.domain.model.Coin
import com.example.cryptocurrencyown.domain.model.CoinDetail

data class CoinDetailState(
    val isLoading: Boolean = false,
    val coin: CoinDetail? = null,
    val error: String = ""
)
