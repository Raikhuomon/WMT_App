package com.tech4dev.wmtapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private lateinit var teamAScore: TextView
    private lateinit var teamBScore: TextView
    private lateinit var enterTeamAScore: EditText
    private lateinit var enterTeamBScore: EditText
    private lateinit var addButton: Button

    private var aScore = ""
    private var bScore = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.addScoreBtn)
        enterTeamAScore = findViewById(R.id.enterTeamAScore)
        enterTeamBScore = findViewById(R.id.enterTeamBScore)
        teamAScore = findViewById(R.id.teamAScore)
        teamBScore = findViewById(R.id.teamBScore)

        addButton.setOnClickListener {
            Toast.makeText(this, "Add Score Was Clicked", Toast.LENGTH_LONG).show()
            aScore = enterTeamAScore.text.toString()
            bScore = enterTeamBScore.text.toString()

            if(aScore.isNullOrEmpty()){
                Toast.makeText(this, "Enter a Valid Number", Toast.LENGTH_LONG).show()
            }else if(bScore.isNullOrEmpty()){
                 Toast.makeText(this, "Enter a Valid Number", Toast.LENGTH_LONG).show()
            }else {
                teamAScore.text = "team A: $aScore"
                teamBScore.text = "team B: $bScore"

                var msg = if(aScore.toInt() > bScore.toInt()){
                    "Team A is the winner"
                }else{
                    "Team B is the winner"
                }
                if(aScore.toInt() == bScore.toInt()){
                    "It's a tie" }


                var alertDialog = AlertDialog.Builder(this)
                alertDialog.setMessage(msg)
                    .setTitle("Who is the winner?")
                    .setPositiveButton("ok", null)
                    .show()
            }

        }


    }
}