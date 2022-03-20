package com.example.diceroller


import junit.framework.TestCase.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun generateNumber() {
        val dice = Dice(MainActivity.SIDES)
        val rollResult = dice.roll()
        assertTrue("Rolled dice out of bounds", rollResult in 1..MainActivity.SIDES)
    }
}