package com.hugidonic.cryptocurrencyapp.presentation.coin_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.hugidonic.cryptocurrencyapp.presentation.ui.theme.CryptoCurrencyAppTheme
import com.hugidonic.domain.entities.CoinModel

@Composable
fun CoinListItem(
    coin: CoinModel,
    onItemClick: (CoinModel) -> Unit
) {
    Row(
        modifier= Modifier
            .fillMaxWidth()
            .clickable { onItemClick(coin) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text="${coin.rank}. ${coin.name} (${coin.symbol})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text= if (coin.isActive) "active" else "inactive",
            color= if(coin.isActive) Color.Green else Color.Red,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body2,
            modifier = Modifier.align(Alignment.CenterVertically)
        )
    }
}

@Preview(name = "CoinListItem")
@Composable
private fun PreviewCoinListItem() {
    CryptoCurrencyAppTheme() {
        Surface {
            CoinListItem(
                coin=CoinModel(
                    id = "btc",
                    isActive = true,
                    name = "Bitcoin",
                    rank = 1,
                    symbol = "BTC"
                ),
                onItemClick = {

                }
            )
        }
    }
}