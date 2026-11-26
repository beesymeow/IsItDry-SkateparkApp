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
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.skateparkisitdry.data.testParks
import com.example.skateparkisitdry.ui.ParkListScreen
import com.example.skateparkisitdry.ui.ParkScreen
import com.example.skateparkisitdry.ui.theme.SkateparkIsItDryTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SkateparkIsItDryTheme {
                SkateparkApp()

            }
        }
    }
}

@Composable
fun SkateparkApp(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = ParkScreen.ParkList.name
    ) {
        composable(route = ParkScreen.ParkList.name){
            ParkListScreen(
                parks = testParks,
                onParkClick = { parkId ->
                    navController.navigate(ParkScreen.ParkDetail.name)
                }
            )
        }

        composable(route = ParkScreen.ParkDetail.name){
            HomeScreen()
        }
    }
}


@Composable
fun HomeScreen ( // Connect ViewModel and UI
    viewModel: HomeViewModel = viewModel(),
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    //Get current state, stop listening if background
    HomeContent(uiState = uiState, onWetClick = viewModel::reportWet)
    // Give UI data and recieve button press info from UI.

}

@Composable
fun HomeContent( // Drawn app with info
    uiState: HomeUiState,  //info shown on screen
    onWetClick: () -> Unit, // Run when button pressed
    modifier: Modifier = Modifier
) {
    val statusText = when (uiState.status) {  // ENUM values become corresponding string resources
        ParkStatus.UNKNOWN -> R.string.status_unknown
        ParkStatus.DRY -> R.string.status_dry
        ParkStatus.WET -> R.string.status_wet
    }

    Scaffold (modifier = modifier) {innerPadding -> // Screen layout
        Column(
            Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp) // distance above items below
        ) {
            Text(text = uiState.park.name)  // Park name
            Text(text = stringResource(statusText)) //Park status
            Button(
                onClick = onWetClick, // When pressed report park is wet
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
fun HomeContentView() {
    SkateparkIsItDryTheme {
        HomeContent(uiState = HomeUiState(park = testParks.first()), onWetClick = {})
    }
}