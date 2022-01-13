package org.android.reminiscencewinter.presentation.util

import android.view.View
import android.view.animation.AlphaAnimation
import android.view.animation.AnimationSet
import android.view.animation.TranslateAnimation

object Extensions {
    fun View.applyVisibilityAnimation(durationTime :Long): AnimationSet {
        val animationSet = AnimationSet(true)
        val alphaAnimation = AlphaAnimation(0f, 1f)
        val translateAnimation = TranslateAnimation(0f, 0f, 70f, 0f)

        alphaAnimation.duration = durationTime
        animationSet.duration = durationTime
        animationSet.addAnimation(alphaAnimation)
        animationSet.addAnimation(translateAnimation)
        startAnimation(animationSet)
        return animationSet
    }
}