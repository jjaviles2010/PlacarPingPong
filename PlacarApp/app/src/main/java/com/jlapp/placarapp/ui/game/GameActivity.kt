package com.jlapp.placarapp.ui.game

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.jlapp.placarapp.R
import com.jlapp.placarapp.ui.game.awayteam.AwayTeamFragment
import com.jlapp.placarapp.ui.game.event.EventFragment
import com.jlapp.placarapp.ui.game.hometeam.HomeTeamFragment
import com.jlapp.placarapp.ui.score.ScoreActivity
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {
    private var eventName = ""
    private var homeTeam = ""
    private var awayTeam = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        showEventFragment()

        registerBroadcastReceiver()

        ivBack.setOnClickListener {
            onBackPressed()
        }


    }

    private fun registerBroadcastReceiver() {
        val intentFilter = IntentFilter("FILTER_EVENT")
        intentFilter.addAction("FILTER_HOME_TEAM")
        intentFilter.addAction("FILTER_AWAY_TEAM")
        LocalBroadcastManager.getInstance(this).registerReceiver(receiver, intentFilter)
    }

    private val receiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            if (intent.hasExtra("event_name")) {
                eventName = intent.getStringExtra("event_name")
                showHomeTeamFragment()
            }

            if (intent.hasExtra("home_team")) {
                homeTeam = intent.getStringExtra("home_team")
                showAwayTeamFragment()
            }

            if (intent.hasExtra("away_team")) {
                awayTeam = intent.getStringExtra("away_team")
                showScoreActivity()
            }
        }
    }

    private fun showHomeTeamFragment() {
        nextFragment(HomeTeamFragment())
    }
    private fun showAwayTeamFragment() {
        nextFragment(AwayTeamFragment())
    }

    private fun nextFragment(fragment: Fragment) {
        val ft = supportFragmentManager?.beginTransaction()
        ft?.setCustomAnimations(
            R.anim.enter_from_right,
            R.anim.exit_to_left,
            R.anim.enter_from_left,
            R.anim.exit_to_right
        )
        ft?.replace(R.id.containerGame, fragment)
        ft?.addToBackStack(null)
        ft?.commit()
    }

    private fun showScoreActivity() {
        val nextScreen = Intent(this@GameActivity, ScoreActivity::class.java)
        nextScreen.putExtra("eventName", eventName)
        nextScreen.putExtra("homeTeam", homeTeam)
        nextScreen.putExtra("awayTeam", awayTeam)
        startActivity(nextScreen)
        finish()
    }

    private fun showEventFragment() {
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.containerGame, EventFragment())
        ft.commit()
    }
}
