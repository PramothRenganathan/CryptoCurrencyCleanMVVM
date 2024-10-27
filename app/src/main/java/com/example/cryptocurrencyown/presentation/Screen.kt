package com.example.cryptocurrencyown.presentation

sealed class Screen(val route: String) {
    data object CoinListScreen : Screen("coin_list")
    data object CoinDetailsScreen : Screen("coin_details")
}