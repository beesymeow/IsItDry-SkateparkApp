package com.example.skateparkisitdry.data

import com.example.skateparkisitdry.model.Drainage
import com.example.skateparkisitdry.model.ParkType
import com.example.skateparkisitdry.model.Shade
import com.example.skateparkisitdry.model.Skatepark
import com.example.skateparkisitdry.model.Surface

val testParks = listOf(
    Skatepark(
        id = "bod",
        name = "Bridge Of Don Skatepark",
        address = "Cardens Knowe, Bridge Of Don, Aberdeen, Scotland, AB24 1RQ",
        what3words = "added.cape.varieties",
        parkType = ParkType.OUTDOOR,
        latitude = 57.1689,
        longitude = -2.1007,
        drainage = Drainage.MODERATE,
        shade = Shade.NONE,
        surface = Surface.SMOOTHISH,
        sourceUrl = "https://skateparks.skateboardscotland.com/bridge-of-don-skatepark/"
    )
)