package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

val SIDES: Int = 6
val LUCKY1 = 1
val LUCKY2 = 2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initial start
        rollDice()

        // R.id.buttons -> resource id for variable button in .xml
        val rollButton: Button = findViewById(R.id.button)

        // Set listener
        rollButton.setOnClickListener {
            rollDice()
        }
    }

    private fun rollDice() {
        val dice = Dice(SIDES)

        val imageView1: ImageView = findViewById(R.id.imageView1)
        val imageView2: ImageView = findViewById(R.id.imageView2)
        val tv1Val = dice.roll()
        val tv2Val = dice.roll()

        if (tv1Val == LUCKY1 && tv2Val == LUCKY2) {
            Toast.makeText(this, "You're LUCKY!", Toast.LENGTH_SHORT).show()
        }

        imageView1.contentDescription = tv1Val.toString()
        imageView2.contentDescription = tv2Val.toString()

        setImage(imageView1, tv1Val)
        setImage(imageView2, tv2Val)
    }

    private fun setImage(imageView: ImageView, diceVal: Int) {
        val dicePict = when (diceVal) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        imageView.setImageResource(dicePict)
    }
}

class Dice(private val sides: Int) {

    fun roll(): Int {
        return (1..sides).random()
    }
}