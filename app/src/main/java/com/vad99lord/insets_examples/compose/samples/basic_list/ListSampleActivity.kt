package com.vad99lord.insets_examples.compose.samples.basic_list

import androidx.compose.runtime.Composable
import com.vad99lord.insets_examples.compose.samples.BaseInsetsSampleActivity
import com.vad99lord.insets_examples.ui.theme.InsetsExamplesTheme

class ListSampleActivity : BaseInsetsSampleActivity() {

    @Composable
    override fun Sample() {
        InsetsExamplesTheme {
            ListSample()
        }
    }
}