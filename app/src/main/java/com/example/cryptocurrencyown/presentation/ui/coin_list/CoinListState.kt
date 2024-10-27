package com.example.cryptocurrencyown.presentation.ui.coin_list

import com.example.cryptocurrencyown.domain.model.Coin

data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
