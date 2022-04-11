package com.vad99lord.insets_examples.compose.samples.gestures

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.vad99lord.insets_examples.compose.samples.BaseInsetSampleActivity
import com.vad99lord.insets_examples.ui.theme.InsetsExamplesTheme

class MandatoryGestureSampleActivity : BaseInsetSampleActivity() {

    @Composable
    override fun Sample() {
        val systemUiController = rememberSystemUiController()
        val useDarkIcons = MaterialTheme.colors.isLight
        SideEffect {
            systemUiController.setSystemBarsColor(
                Color.Transparent,
                darkIcons = useDarkIcons
            )
        }
        InsetsExamplesTheme {
            MandatoryGestureSample()
        }
    }
}