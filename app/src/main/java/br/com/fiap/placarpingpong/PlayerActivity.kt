package br.com.fiap.placarpingpong

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_player.*

class PlayerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player)

        btStartGame.setOnClickListener {
            val intent = Intent(this, PlacarActivity::class.java)
            intent.putExtra("PLAYER_1", inputPlayer1.text.toString())
            intent.putExtra("PLAYER_2", inputPlayer2.text.toString())
            startActivity(intent)
        }
    }
}
