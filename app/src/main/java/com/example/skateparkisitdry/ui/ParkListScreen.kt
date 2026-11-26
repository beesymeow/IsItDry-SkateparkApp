package com.example.skateparkisitdry.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.skateparkisitdry.data.testParks
import com.example.skateparkisitdry.model.Skatepark
import com.example.skateparkisitdry.ui.theme.SkateparkIsItDryTheme

@Composable
fun ParkListScreen(  // Screen recieves user inputss
    parks: List<Skatepark>, // What parks to show
    onParkClick: (String) -> Unit, // Calls park.Id when clicked
    modifier: Modifier = Modifier
) {
    Scaffold(modifier = modifier) { innerPadding ->
        LazyColumn(  // Draw rows that fit on screen, keeps performance for large lists
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items = parks, key = { park -> park.id }) { park ->  // park.Id as key so each row stays as that park
                ParkCard(park = park, onClick = { onParkClick(park.id) })
            }
        }
    }
}

@Composable
private fun ParkCard( // Model of skatepark details card
    park: Skatepark,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = park.name, style = MaterialTheme.typography.titleMedium) // Park name larger
            Text(
                text = park.address, // Address smaller
                style = MaterialTheme.typography.bodySmall,
                maxLines = 1, // Only display for one line
                overflow = TextOverflow.Ellipsis // If goes off screen show ...
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ParkListScreenPreview() {
    SkateparkIsItDryTheme {
        ParkListScreen(parks = testParks, onParkClick = {})
    }
}