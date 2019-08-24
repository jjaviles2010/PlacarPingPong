package com.jlapp.jokenpo.ui.game

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jlapp.jokenpo.R
import com.jlapp.jokenpo.ui.game.player.PlayerFragment

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        showPlayerFragment()
    }

    private fun showPlayerFragment() {
        val ft = supportFragmentManager.beginTransaction()
        if(supportFragmentManager.findFragmentByTag("PlayerFragment") == null) {
            ft.add(R.id.containerGame, PlayerFragment(), "PlayerFragment")
            ft.commit()
        }
    }
}
