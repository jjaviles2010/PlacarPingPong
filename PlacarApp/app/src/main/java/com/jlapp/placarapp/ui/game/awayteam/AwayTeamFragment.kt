package com.jlapp.placarapp.ui.game.awayteam


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jlapp.placarapp.R
import com.jlapp.placarapp.ui.score.ScoreActivity
import kotlinx.android.synthetic.main.fragment_away_team.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class AwayTeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_away_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btNextStep.setOnClickListener {
            nextScreen()
        }
    }

    private fun nextScreen() {
        val nextScreen = Intent(activity, ScoreActivity::class.java)
        startActivity(nextScreen)
        activity?.finish()
    }


}
