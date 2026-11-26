package com.example.skateparkisitdry.ui

import androidx.annotation.StringRes
import com.example.skateparkisitdry.R

enum class ParkScreen(@param:StringRes val title: Int){
    ParkList(title = R.string.screen_park_list),
    ParkDetail(title = R.string.screen_park_detail)
    }
