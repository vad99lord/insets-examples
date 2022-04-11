package com.vad99lord.insets_examples.compose.samples.fullscreen

import android.os.Build
import android.view.WindowManager
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.vad99lord.insets_examples.compose.samples.BaseInsetSampleActivity
import com.vad99lord.insets_examples.compose.ui_visibility.rememberSystemUiVisibilityController
import com.vad99lord.insets_examples.ui.theme.InsetsExamplesTheme

class FullscreenStableSampleActivity : BaseInsetSampleActivity() {

    override fun setupOnCreate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.attributes.layoutInDisplayCutoutMode =
                WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_ALWAYS
        }
    }

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
        val systemUiVisibilityController = rememberSystemUiVisibilityController()
        val toggleUi = {
            with(systemUiVisibilityController) {
                isSystemBarsVisible = !isSystemBarsVisible
            }
        }
        InsetsExamplesTheme {
            FullscreenStableSample(
                toggleUi = toggleUi,
                isSystemUiVisible = systemUiVisibilityController.isVisible
            )
        }
    }
}