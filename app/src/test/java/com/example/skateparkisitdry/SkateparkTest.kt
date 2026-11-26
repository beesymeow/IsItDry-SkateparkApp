package com.example.skateparkisitdry

import com.example.skateparkisitdry.data.testParks
import com.example.skateparkisitdry.model.Drainage
import com.example.skateparkisitdry.model.ParkType
import com.example.skateparkisitdry.model.Shade
import com.example.skateparkisitdry.model.Surface
import org.junit.Test
import org.junit.Assert.assertEquals

class SkateparkTest {

    @Test
    fun parkSharesValues() {
        val park = testParks.first() // Choose park object to test (first in park list)

        assertEquals("bod", park.id) // does park.id give expected val
        assertEquals("Bridge Of Don Skatepark", park.name)
        assertEquals("Cardens Knowe, Bridge Of Don, Aberdeen, Scotland, AB22 8PE", park.address)
        assertEquals(ParkType.OUTDOOR, park.parkType)
        assertEquals(Drainage.MODERATE, park.drainage)
        assertEquals(Shade.NONE, park.shade)
        assertEquals(Surface.SMOOTHISH, park.surface)
        assertEquals("https://skateparks.skateboardscotland.com/bridge-of-don-skatepark/", park.sourceUrl)
        assertEquals(57.184879, park.latitude, 0.0001)
    }
}