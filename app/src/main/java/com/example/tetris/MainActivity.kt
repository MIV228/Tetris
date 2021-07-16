package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.tetris.storage.AppPreferences

class MainActivity : AppCompatActivity() {

    var tvHighScore: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val btn_new_game = findViewById<Button>(R.id.btn_new_game)
        val btn_reset_score = findViewById<Button>(R.id.btn_reset_score)
        val btn_exit = findViewById<Button>(R.id.btn_exit)
        tvHighScore = findViewById(R.id.tv_high_score)

        btn_new_game.setOnClickListener(this::onBtnNewGameClick)


    }

    private fun onBtnNewGameClick(view: View) {
        val perehod = Intent(this, GameActivity::class.java)
        startActivity(perehod)
    }

    private fun onBtnResetScoreClick(view: View) {
        val preferences = AppPreferences(this)
        preferences.clearHighScore()
        Snackbar.make(view, "Score succesfully reset", Snackbar.LENGTH_SHORT).show()
        tvHighScore?.text = "High score: ${preferences.getHighScore()}"
    }

    private fun onBtnExitClick(view: View) {
        System.exit(0)
    }

}