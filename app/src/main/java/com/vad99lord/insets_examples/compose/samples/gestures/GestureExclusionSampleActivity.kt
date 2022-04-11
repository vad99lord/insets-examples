package com.vad99lord.insets_examples.compose.samples.gestures

import androidx.compose.runtime.Composable
import com.vad99lord.insets_examples.compose.samples.BaseInsetsSampleActivity
import com.vad99lord.insets_examples.ui.theme.InsetsExamplesTheme

class GestureExclusionSampleActivity : BaseInsetsSampleActivity() {

    @Composable
    override fun Sample() {
        InsetsExamplesTheme {
            GestureExclusionSample()
        }
    }
}