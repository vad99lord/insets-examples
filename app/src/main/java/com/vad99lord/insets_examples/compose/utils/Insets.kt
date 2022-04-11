package com.vad99lord.insets_examples.compose.utils

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.exclude
import androidx.compose.foundation.layout.statusBars
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

/*
Workaround class to cache status bars insets
based on the biggest top side inset
(assuming intermediate values during
system ui visibility changes)
 */
class StableStatusBarsInsetsHolder {

    private var stableStatusBarsInsets: WindowInsets = Empty

    val stableStatusBars: WindowInsets
        @Composable
        get() {
            val density = LocalDensity.current
            val layoutDirection = LocalLayoutDirection.current
            val statusBars = WindowInsets.statusBars
            return remember {
                derivedStateOf {
                    if (statusBars.exclude(stableStatusBarsInsets).getTop(density) > 0) {
                        // get a copy of insets because statusBars is backed by an implementation
                        // with auto updatable property causing cached insets changes
                        stableStatusBarsInsets = statusBars.deepCopy(density, layoutDirection)
                    }
                    stableStatusBarsInsets
                }
            }.value
        }

    companion object {
        val Empty = WindowInsets(0.dp)
    }
}

fun WindowInsets.deepCopy(density: Density, layoutDirection: LayoutDirection): WindowInsets {
    return WindowInsets(
        left = getLeft(density, layoutDirection),
        top = getTop(density),
        right = getRight(density, layoutDirection),
        bottom = getBottom(density)
    )
}