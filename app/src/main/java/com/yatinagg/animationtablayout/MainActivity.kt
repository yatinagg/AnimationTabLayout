package com.yatinagg.animationtablayout

import android.R.attr
import android.app.Dialog
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.yatinagg.animationtablayout.cards.Card
import android.view.Gravity
import android.R.attr.y

import android.R.attr.x
import android.view.WindowManager
import com.yatinagg.animationtablayout.popupCard.PopupCardViewAdapter
import kotlin.math.abs


class MainActivity : CardViewActivity() {

    private lateinit var tabLayout: TabLayout

    override val layoutId: Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = findViewById<LinearLayout>(R.id.main_layout)
        view.background = ContextCompat.getDrawable(this, R.drawable.gradient1)
        tabLayout = findViewById(R.id.tabs)
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = Card.DECK[position].toString()
        }.attach()
        showDialogBox()
    }

    private fun showDialogBox(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.popup_pager_layout)

        val window = dialog.window
        window!!.setGravity(Gravity.BOTTOM)
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT,800)

        val animator = ViewPager2.PageTransformer { page, position ->
            val absPos = abs(position)
            page.apply {
//            rotation = position*180
                translationX = absPos * 500f
                translationY = absPos * 350f
            }
        }

        val viewPagerPopup = dialog.findViewById<ViewPager2>(R.id.view_pager1)
        println(viewPagerPopup)

        viewPagerPopup.setPageTransformer(animator)
        viewPagerPopup.adapter = PopupCardViewAdapter()


        dialog.show()
    }
}
