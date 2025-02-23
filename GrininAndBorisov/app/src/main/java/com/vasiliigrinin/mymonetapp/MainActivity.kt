package com.vasiliigrinin.mymonetapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var onceFlipButton: Button
    private lateinit var someFlipButton: Button
    private lateinit var coinImg: ImageView
    private var status: Boolean = true


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        onceFlipButton = findViewById(R.id.onceFlip)
        someFlipButton = findViewById(R.id.someFlip)
        coinImg = findViewById(R.id.coinView)

        onceFlipButton.setOnClickListener {
            if (status) {
                if (flipCoin()) {
                    coinImg.setImageResource(R.drawable.eagle)
                } else {
                    coinImg.setImageResource(R.drawable.tails)
                }
                onceFlipButton.text = "Ещё раз?"
                status = false
            }else{
                coinImg.setImageResource(R.drawable.start_img)
                status = true
                onceFlipButton.text = "Подбросить один раз"
            }


        }

        someFlipButton.setOnClickListener {
            // start your next activity
            val intent = Intent(this@MainActivity, SomeMonetActivity::class.java)
            startActivity(intent)
        }


    }
}