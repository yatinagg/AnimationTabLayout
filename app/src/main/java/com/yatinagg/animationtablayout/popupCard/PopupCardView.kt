package com.yatinagg.animationtablayout.popupCard

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import com.yatinagg.animationtablayout.R
import com.yatinagg.animationtablayout.cards.Card

class PopupCardView(layoutInflater: LayoutInflater, container: ViewGroup?) {
    val view: View = layoutInflater.inflate(R.layout.item_popup_layout, container, false)
    private val textSuite: TextView

    init {
        textSuite = view.findViewById(R.id.label_center1)
    }

    /**
     * Updates the view to represent the passed in card
     */
    fun bind(card: PopupCard) {
        textSuite.text = card.text
    }

    @ColorRes
    private fun getColorRes(card: Card): Int {
        val shade = getShade(card)
        val color = getColor(card)
        return COLOR_MAP[color][shade]
    }

    private fun getShade(card: Card): Int {
        when (card.value) {
            "2", "6", "10", "A" -> return 2
            "3", "7", "J" -> return 3
            "4", "8", "Q" -> return 0
            "5", "9", "K" -> return 1
        }
        throw IllegalStateException("Card value cannot be $card.value")
    }

    private fun getColor(card: Card): Int {
        when (card.suit) {
            "♣" -> return 0
            "♦" -> return 1
            "♥" -> return 2
            "♠" -> return 3
        }
        throw IllegalStateException("Card suit cannot be $card.suit")
    }

    companion object {
        private val COLOR_MAP = arrayOf(
            intArrayOf(R.color.red_100, R.color.red_300, R.color.red_500, R.color.red_700),
            intArrayOf(R.color.blue_100, R.color.blue_300, R.color.blue_500, R.color.blue_700),
            intArrayOf(
                R.color.green_100, R.color.green_300, R.color.green_500,
                R.color.green_700
            ),
            intArrayOf(
                R.color.yellow_100, R.color.yellow_300, R.color.yellow_500,
                R.color.yellow_700
            )
        )
    }
}
