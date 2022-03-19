package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

val SIDES: Int = 6
val LUCKY1 = 1
val LUCKY2 = 2

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
        }
    }

    private fun rollDice() {
        val dice = Dice(SIDES)
        val resultTextView: TextView = findViewById(R.id.textView)
        val resultTextView2: TextView = findViewById(R.id.textView2)
        val tv1Val = dice.roll()
        val tv2Val = dice.roll()

        if (tv1Val == LUCKY1 && tv2Val == LUCKY2) {
            Toast.makeText(this, "You're LUCKY!", Toast.LENGTH_SHORT).show()
        }

        resultTextView.text = tv1Val.toString()
        resultTextView2.text = tv2Val.toString()
    }
}

class Dice(private val sides: Int) {

    fun roll(): Int {
        return (1..sides).random()
    }
}