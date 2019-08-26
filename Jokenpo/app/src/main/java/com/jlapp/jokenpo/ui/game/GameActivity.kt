package com.jlapp.jokenpo.ui.game

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.jlapp.jokenpo.R
import com.jlapp.jokenpo.ui.game.match.MatchFragment
import com.jlapp.jokenpo.ui.game.player.PlayerFragment
import kotlinx.android.synthetic.main.fragment_match.*

class GameActivity : AppCompatActivity() {

    private lateinit var gameViewModel: GameViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        registerObserver()

        setExtras()
    }

    private fun setExtras() {
        intent.getStringExtra("player_name")?.apply {
            gameViewModel.playerName.value = this
        }
    }

    private fun registerObserver() {

        gameViewModel.playerName.observe(this, Observer {
            tvPlayerGame.text = it
        })

        gameViewModel.victoryNumbers.observe(this, Observer {
            tvVictoryNumber.text = it.toString()
        })

        gameViewModel.defeatNumbers.observe(this, Observer {
            tvDefeatsNumber.text = it.toString()
        })

        gameViewModel.playerImage.observe(this, Observer {
            ivPlayer.setImageDrawable(ContextCompat.getDrawable(this, it))
        })

        gameViewModel.androidImage.observe(this, Observer {
            ivAndroid.setImageDrawable(ContextCompat.getDrawable(this, it))
        })

        gameViewModel.roundState.observe(this, Observer {
            tvRoundResult.text = it.toString()
        })
    }

}
