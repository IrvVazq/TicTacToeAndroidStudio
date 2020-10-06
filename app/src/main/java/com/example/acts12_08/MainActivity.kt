package com.example.acts12_08

import android.R.layout
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder= AlertDialog.Builder(this)
        builder.setTitle("Game Over")
        builder.setMessage("Restart?")
    }

    var turn = true
    var turnNum= 0
    var game = true
    var x = "X"
    var o = "O"
    var aryBtns= arrayOfNulls<Button>(9)
    fun asingAry(){
        for(i in 1..9){
            var btn = findViewById<Button>(resources.getIdentifier("button$i","id",packageName))
            aryBtns[i-1]=btn
        }
    }

    fun btnClick(view: View){
        if(game) {
            view.setEnabled(false)
            asingAry()
            var btn = view as Button
            if (turn) {
                btn.setText(x)
                btn.setBackgroundColor(Color.BLUE)
                btn.setTextColor(Color.WHITE)
                turn = !turn
                for (i in 1..9) {
                    if (view.id == aryBtns[i - 1]!!.id) {
                        aryBtns[i - 1] == view
                    }
                }
                turnNum++
                winner(x)
            } else {
                btn.setText(o)
                btn.setBackgroundColor(Color.RED)
                btn.setTextColor(Color.WHITE)
                turn = !turn
                for (i in 1..9) {
                    if (view.id == aryBtns[i - 1]!!.id) {
                        aryBtns[i - 1] == view
                    }
                }
                turnNum++
                winner(o)
            }
        }
    }

    fun winner(playerWinner: String){
        //Ganar por lineas horizontales
        if(aryBtns[0]!!.text == playerWinner && aryBtns[1]!!.text == playerWinner && aryBtns[2]!!.text == playerWinner){
            println("HA GANADO: "+playerWinner)
            var text = findViewById<TextView>(resources.getIdentifier("winnerLabel","id",packageName))
            text.setText("WINNER: $playerWinner")
            game=!game
        }else{
            if(aryBtns[3]!!.text == playerWinner && aryBtns[4]!!.text == playerWinner && aryBtns[5]!!.text == playerWinner){
                println("HA GANADO: "+playerWinner)
                var text = findViewById<TextView>(resources.getIdentifier("winnerLabel","id",packageName))
                text.setText("WINNER: $playerWinner")
                game=!game
            }else{
                if(aryBtns[6]!!.text == playerWinner && aryBtns[7]!!.text == playerWinner && aryBtns[8]!!.text == playerWinner){
                    println("HA GANADO: "+playerWinner)
                    var text = findViewById<TextView>(resources.getIdentifier("winnerLabel","id",packageName))
                    text.setText("WINNER: $playerWinner")
                    game=!game
                }
            }
        }

        //Ganar por lineas verticales
        if(aryBtns[0]!!.text == playerWinner && aryBtns[3]!!.text == playerWinner && aryBtns[6]!!.text == playerWinner){
            println("HA GANADO: "+playerWinner)
            var text = findViewById<TextView>(resources.getIdentifier("winnerLabel","id",packageName))
            text.setText("WINNER: $playerWinner")
            game=!game
        }else{
            if(aryBtns[1]!!.text == playerWinner && aryBtns[4]!!.text == playerWinner && aryBtns[7]!!.text == playerWinner){
                println("HA GANADO: "+playerWinner)
                var text = findViewById<TextView>(resources.getIdentifier("winnerLabel","id",packageName))
                text.setText("WINNER: $playerWinner")
                game=!game
            }else{
                if(aryBtns[2]!!.text == playerWinner && aryBtns[5]!!.text == playerWinner && aryBtns[8]!!.text == playerWinner){
                    println("HA GANADO: "+playerWinner)
                    var text = findViewById<TextView>(resources.getIdentifier("winnerLabel","id",packageName))
                    text.setText("WINNER: $playerWinner")
                    game=!game
                }
            }
        }

        //Ganar por diagonal
        if(aryBtns[0]!!.text == playerWinner && aryBtns[4]!!.text == playerWinner && aryBtns[8]!!.text == playerWinner){
            println("HA GANADO: "+playerWinner)
            var text = findViewById<TextView>(resources.getIdentifier("winnerLabel","id",packageName))
            text.setText("WINNER: $playerWinner")
            game=!game
        }else{
            if(aryBtns[2]!!.text == playerWinner && aryBtns[4]!!.text == playerWinner && aryBtns[6]!!.text == playerWinner){
                println("HA GANADO: "+playerWinner)
                var text = findViewById<TextView>(resources.getIdentifier("winnerLabel","id",packageName))
                text.setText("WINNER: $playerWinner")
                game=!game
            }
        }

        //Empate
        if(turnNum==9 && game == true){
            println("EMPATE")
            var text = findViewById<TextView>(resources.getIdentifier("winnerLabel","id",packageName))
            text.setText("DRAW")
            game=!game
        }
    }

}
