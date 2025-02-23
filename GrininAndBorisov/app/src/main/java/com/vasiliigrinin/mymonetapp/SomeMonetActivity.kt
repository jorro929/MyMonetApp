package com.vasiliigrinin.mymonetapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class SomeMonetActivity : AppCompatActivity() {

    private lateinit var textInput: EditText
    private lateinit var incrementButton: Button
    private lateinit var decrementButton: Button
    private lateinit var exitButton: Button
    private lateinit var flipCoinButton: Button
    private lateinit var counterEagle: TextView
    private lateinit var counterTails: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_some_monet)

        // Инициализация элементов интерфейса
        textInput = findViewById(R.id.textInput)
        incrementButton = findViewById(R.id.incrementButton)
        decrementButton = findViewById(R.id.decrementButton)
        exitButton = findViewById(R.id.exitButton)
        flipCoinButton = findViewById(R.id.flipCoinButton)
        counterEagle = findViewById(R.id.counterTextView1)
        counterTails = findViewById(R.id.counterTextView2)

        // Установка начального значения в EditText
        textInput.setText("0")

        // Установка обработчиков кликов для кнопок
        incrementButton.setOnClickListener {
            val currentValue = textInput.text.toString().toIntOrNull() ?: 0
            textInput.setText((currentValue + 1).toString())
        }

        decrementButton.setOnClickListener {
            val currentValue = textInput.text.toString().toIntOrNull() ?: 0
            if(currentValue >= 1){
                textInput.setText((currentValue - 1).toString())
            }
        }

        // Установка обработчика кликов для кнопки "Выход на главный экран"
        exitButton.setOnClickListener {
            finish() // Закрывает текущую активность
        }

        // Установка обработчика кликов для кнопки "Подбросить монету"
        flipCoinButton.setOnClickListener {
            var countEagle: Int = 0;
            var countTails: Int = 0;

            val numberOfFlips = textInput.text.toString().toIntOrNull() ?: 0
            for (i in 1..numberOfFlips) {
                if (flipCoin()){
                    countEagle++;
                }else{
                    countTails++;
                }
            }

            counterEagle.text = "Счётчик орла:" + countEagle;
            counterTails.text = "Счётчик решки:" + countTails;

        }
    }



}