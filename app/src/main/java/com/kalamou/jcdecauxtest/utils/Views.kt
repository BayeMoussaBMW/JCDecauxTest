package com.kalamou.jcdecauxtest.utils

import android.view.View

fun View.visibleOrGone(visible: Boolean) {
    visibility = if (visible) View.VISIBLE else View.GONE
}