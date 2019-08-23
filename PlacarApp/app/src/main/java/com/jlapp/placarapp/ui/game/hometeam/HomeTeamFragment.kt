package com.jlapp.placarapp.ui.game.hometeam


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.localbroadcastmanager.content.LocalBroadcastManager

import com.jlapp.placarapp.R
import com.jlapp.placarapp.ui.game.awayteam.AwayTeamFragment
import kotlinx.android.synthetic.main.fragment_home_team.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeTeamFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_team, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btNextStep.setOnClickListener {
            sendHomeTeamName()
//            nextScreen()
        }
    }

    private fun sendHomeTeamName() {
        val intent = Intent("FILTER_HOME_TEAM")
        intent.putExtra("home_team", inputHomeTeam.text.toString())
        LocalBroadcastManager.getInstance(requireContext()).sendBroadcast(intent)
    }

    private fun nextScreen() {
        val ft = activity?.supportFragmentManager?.beginTransaction()
        ft?.replace(R.id.containerGame, AwayTeamFragment())
        ft?.addToBackStack(null)
        ft?.commit()
    }

}
