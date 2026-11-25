package com.example.skateparkisitdry.model

enum class ParkType { OUTDOOR, INDOOR }
enum class Drainage { GOOD, MODERATE, POOR }
enum class Shade { NONE, PARTLY, COVERED }
enum class Surface { SMOOTH, SMOOTHISH, ROUGH, WOOD }

data class Skatepark(
    val id: String,
    val name: String,
    val address: String,
    val what3words: String? = null,
    val parkType: ParkType,
    val latitude: Double,
    val longitude: Double,
    val drainage: Drainage,
    val shade: Shade,
    val surface: Surface,
    val sourceUrl: String

)
