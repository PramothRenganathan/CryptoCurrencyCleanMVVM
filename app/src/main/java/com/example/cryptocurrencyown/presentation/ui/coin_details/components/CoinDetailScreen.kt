package com.example.cryptocurrencyown.presentation.ui.coin_details.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.cryptocurrencyown.data.remote.dto.TeamMember
import com.example.cryptocurrencyown.presentation.Screen
import com.example.cryptocurrencyown.presentation.ui.coin_details.CoinDetailViewModel
import com.example.cryptocurrencyown.presentation.ui.coin_list.CoinListViewModel
import com.example.cryptocurrencyown.presentation.ui.coin_list.components.CoinListItem

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coinDetail ->
            LazyColumn(modifier = Modifier.fillMaxSize()){
                item {
                   Row (modifier = Modifier
                       .fillMaxWidth(),
                       horizontalArrangement = Arrangement.SpaceBetween) {
                       Text(
                           text = "${coinDetail.rank}. ${coinDetail.name} ${coinDetail.symbol}",
                           style = MaterialTheme.typography.headlineLarge,
                           
                       )
                   }
                    Spacer(modifier = Modifier.height(4.dp))
                    
                    Text(text = coinDetail.description)
                    
                    Text(text = "Tags",
                        style = MaterialTheme.typography.headlineMedium)

                    Spacer(modifier = Modifier.height(4.dp))

                    FlowRow(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coinDetail.tags.forEach{
                            CoinTag(tag = it)
                        }
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    Text(text = "TeamMembers",
                        style = MaterialTheme.typography.headlineMedium)

                    Spacer(modifier = Modifier.height(4.dp))

                }
                items(coinDetail.team) {item ->
                    TeamListItem(teamMember = item, modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                    Divider()
                }
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
            CircularProgressIndicator(modifier = Modifier
                .align(Alignment.Center)
            )
        }
    }

}