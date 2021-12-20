package com.yatinagg.animationtablayout

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.widget.ViewPager2
import kotlin.math.abs

abstract class BaseCardActivity : FragmentActivity() {

    protected lateinit var viewPager: ViewPager2

    protected open val layoutId: Int = R.layout.activity_main

    private val mAnimator = ViewPager2.PageTransformer { page, position ->
        val absPos = abs(position)
        page.apply {
//            rotation = position*180
            translationX = absPos * 500f
            translationY = absPos * 350f
        }
    }

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId)

        viewPager = findViewById(R.id.view_pager)
        viewPager.setPageTransformer(mAnimator)
    }

}
