package com.app.sushipoint

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.app.sushipoint.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var numPlayer: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        numPlayer = "2"
        binding.editJug.text = numPlayer
        binding.botMas.setOnClickListener {
            addPlayer()
        }
        binding.botMenos.setOnClickListener {
            delPlayer()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun addPlayer() {
        if (binding.editJug.text.toString().toInt() <= 4) {
            numPlayer = (binding.editJug.text.toString().toInt() + 1).toString()
            binding.editJug.text = numPlayer
            calcuCards()
        }
    }

    private fun delPlayer() {
        if (binding.editJug.text.toString().toInt() in 3..5) {
            numPlayer = (binding.editJug.text.toString().toInt() - 1).toString()
            binding.editJug.text = numPlayer
            calcuCards()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calcuCards() {
        when (numPlayer) {
            "2" -> binding.numCards.text = "Para 2 jugadores se repartirán 10 cartas"
            "3" -> binding.numCards.text = "Para 3 jugadores se repartirán 9 cartas"
            "4" -> binding.numCards.text = "Para 4 jugadores se repartirán 8 cartas"
            "5" -> binding.numCards.text = "Para 5 jugadores se repartirán 7 cartas"
        }
    }
}