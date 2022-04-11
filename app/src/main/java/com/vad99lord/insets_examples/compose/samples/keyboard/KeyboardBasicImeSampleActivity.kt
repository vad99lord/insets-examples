package com.vad99lord.insets_examples.compose.samples.keyboard

import androidx.compose.runtime.Composable
import com.vad99lord.insets_examples.compose.samples.BaseInsetsSampleActivity
import com.vad99lord.insets_examples.compose.utils.setResizeSoftInputMode
import com.vad99lord.insets_examples.ui.theme.InsetsExamplesTheme

class KeyboardBasicImeSampleActivity : BaseInsetsSampleActivity() {

    override fun setupOnCreate() {
        window.setResizeSoftInputMode()
    }

    @Composable
    override fun Sample() {
        InsetsExamplesTheme {
            KeyboardBasicImeSample()
        }
    }
}