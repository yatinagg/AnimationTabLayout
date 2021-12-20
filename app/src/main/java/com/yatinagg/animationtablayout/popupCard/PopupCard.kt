package com.yatinagg.animationtablayout.popupCard

import androidx.core.text.BidiFormatter

class PopupCard private constructor(val text: String) {

    override fun toString(): String {
        val bidi = BidiFormatter.getInstance()
        return bidi.unicodeWrap("$text")
    }

    companion object {

        val SUITS = setOf("♣" /* clubs*/, "♦" /* diamonds*/, "♥" /* hearts*/, "♠" /*spades*/)
        val VALUES = setOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
        val DECK = SUITS.flatMap { suit ->
            PopupCard(suit)
            VALUES.map { value -> PopupCard(suit) }
        }

    }
}
