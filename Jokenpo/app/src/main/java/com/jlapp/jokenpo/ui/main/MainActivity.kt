package com.jlapp.jokenpo.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jlapp.jokenpo.R
import com.jlapp.jokenpo.ui.game.GameActivity
import com.jlapp.jokenpo.ui.player.PlayerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btStartGame.setOnClickListener {
            val intent = Intent(this, PlayerActivity::class.java)
            startActivity(intent)
        }

        btEndApp.setOnClickListener { finish() }
    }
}
