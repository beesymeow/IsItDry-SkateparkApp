package com.example.skateparkisitdry

import com.example.skateparkisitdry.data.testParks
import org.junit.Test
import org.junit.Assert.assertNull
import org.junit.Assert.assertNotNull


class what3wordsNullTest() {


    @Test
    fun what3wordsNullableTest() {
        val w3wNull = testParks.first().copy(what3words = null)
        assertNull(w3wNull.what3words)

        val w3w = testParks.first()
        assertNotNull(w3w.what3words)

    }
}