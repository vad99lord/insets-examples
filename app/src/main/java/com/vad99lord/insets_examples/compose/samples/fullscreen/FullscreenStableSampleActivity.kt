package com.vad99lord.insets_examples.compose.samples.fullscreen

import androidx.compose.runtime.Composable
import com.vad99lord.insets_examples.compose.samples.BaseInsetsSampleActivity
import com.vad99lord.insets_examples.compose.utils.rememberSystemUiVisibilityController
import com.vad99lord.insets_examples.compose.utils.toggleUi
import com.vad99lord.insets_examples.compose.utils.setDisplayCutoutModeAlways
import com.vad99lord.insets_examples.ui.theme.InsetsExamplesTheme

class FullscreenStableSampleActivity : BaseInsetsSampleActivity() {

    override fun setupOnCreate() {
        window.setDisplayCutoutModeAlways()
    }

    @Composable
    override fun Sample() {
        val systemUiVisibilityController = rememberSystemUiVisibilityController()
        InsetsExamplesTheme {
            FullscreenStableSample(
                toggleUi = systemUiVisibilityController.toggleUi,
                isSystemUiVisible = systemUiVisibilityController.isVisible
            )
        }
    }
}