package com.yatinagg.animationtablayout.popupCard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yatinagg.animationtablayout.cards.Card

class PopupCardViewAdapter : RecyclerView.Adapter<CardViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        return CardViewHolder(PopupCardView(LayoutInflater.from(parent.context), parent))
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(PopupCard.DECK[position])
    }

    override fun getItemCount(): Int {
        return PopupCard.DECK.size
    }
}

class CardViewHolder internal constructor(private val cardView: PopupCardView) :
    RecyclerView.ViewHolder(cardView.view) {
    internal fun bind(card: PopupCard) {
        cardView.bind(card)
    }
}
