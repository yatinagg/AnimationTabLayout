package com.yatinagg.animationtablayout.cards

import android.os.Bundle
import androidx.core.text.BidiFormatter

/**
 * Playing card
 */
class Card private constructor(val suit: String, val value: String) {

    val cornerLabel: String
        get() = value + "\n" + suit

    override fun toString(): String {
        val bidi = BidiFormatter.getInstance()
        if (!bidi.isRtlContext) {
            return bidi.unicodeWrap("$value $suit")
        } else {
            return bidi.unicodeWrap("$suit $value")
        }
    }

    companion object {

        val SUITS = setOf("♣" /* clubs*/, "♦" /* diamonds*/, "♥" /* hearts*/, "♠" /*spades*/)
        val VALUES = setOf("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A")
        val DECK = SUITS.flatMap { suit ->
            VALUES.map { value -> Card(suit, value) }
        }

    }
}
