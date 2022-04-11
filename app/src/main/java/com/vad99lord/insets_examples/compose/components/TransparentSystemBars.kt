package com.vad99lord.insets_examples.compose.components

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

// Update the system bars to be translucent
// Adjusts icons color to theme
@Composable
fun TransparentSystemBars() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight
    SideEffect {
        systemUiController.setSystemBarsColor(
            Color.Transparent,
            darkIcons = useDarkIcons
        )
    }
}