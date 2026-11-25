package com.example.skateparkisitdry

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skateparkisitdry.ui.theme.SkateparkIsItDryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkateparkIsItDryTheme {
                HomeScreen()

            }
        }
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    var isWet by remember { mutableStateOf(false) }

    Scaffold {innerPadding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            Text(text = "Skatepark")
            Text(text = if (isWet) stringResource(R.string.status_wet) else stringResource(R.string.status_dry))
            Button(
                onClick = { isWet = true },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
            )
            {
                Text(stringResource(R.string.wet_questionmark))
            }
        }
    }




}

@Preview(showBackground = true)
@Composable
fun HomeScreenView() {
    SkateparkIsItDryTheme {
        HomeScreen()
    }
}