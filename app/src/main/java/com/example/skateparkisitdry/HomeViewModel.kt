package com.example.skateparkisitdry

import androidx.lifecycle.ViewModel
import com.example.skateparkisitdry.data.testParks
import com.example.skateparkisitdry.model.Skatepark
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

enum class ParkStatus { UNKNOWN, DRY, WET } // UNKNOWN by default until app recieves information about park

data class HomeUiState(
    val park: Skatepark,
    val status: ParkStatus = ParkStatus.UNKNOWN
)

class HomeViewModel : ViewModel() { // Holds home screen state regardless of activity so screen rotations
                                    // dont reset to default state.
    private val _uiState = MutableStateFlow(HomeUiState(park = testParks.first()))
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    fun reportWet() {  // user reports a wet skatepark. Update changes the state to WET
        _uiState.update { it.copy(status = ParkStatus.WET)}
    }
}