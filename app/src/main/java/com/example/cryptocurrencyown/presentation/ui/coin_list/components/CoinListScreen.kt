package com.example.cryptocurrencyown.presentation.ui.coin_list.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocurrencyown.presentation.Screen
import com.example.cryptocurrencyown.presentation.ui.coin_list.CoinListViewModel

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.coins) { coin ->
                CoinListItem(coin = coin, onItemClick = {
                    navController.navigate(Screen.CoinDetailsScreen.route + "/${coin.id}")
                }
                )

            }
        }

        if (state.error.isNotBlank()) {
            Text(text = state.error,
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                color = MaterialTheme.colorScheme.error
            )
        }
        if (state.isLoading) {
//            CircularProgressIndicator(modifier = Modifier
//                .align(Alignment.Center)
//            )
        }
    }

}