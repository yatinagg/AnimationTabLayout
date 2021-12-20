package com.yatinagg.animationtablayout

import android.os.Bundle
import com.yatinagg.animationtablayout.cards.CardViewAdapter

open class CardViewActivity : BaseCardActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewPager.adapter = CardViewAdapter()
    }
}
