package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

val SIDES: Int = 6

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Code below

        // R.id.buttons -> resource id for variable button in .xml
        val rollButton: Button = findViewById(R.id.button)

        // Set listener
        rollButton.setOnClickListener {
            rollDice()
            Toast.makeText(this, "Dice rolled!", Toast.LENGTH_SHORT).show()
        }
    }

    private fun rollDice() {
        val dice = Dice(SIDES)
        val resultTextView: TextView = findViewById(R.id.textView)
        val resultTextView2: TextView = findViewById(R.id.textView2)
        resultTextView.text = dice.roll().toString()
        resultTextView2.text = dice.roll().toString()
    }
}

class Dice(private val sides: Int) {

    fun roll(): Int {
        return (1..sides).random()
    }
}