package com.vad99lord.insets_examples.compose.samples.gestures

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.mandatorySystemGestures
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.union
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import com.vad99lord.insets_examples.R
import com.vad99lord.insets_examples.compose.components.SampleMediaPlayer
import com.vad99lord.insets_examples.compose.components.SampleTopBar

@Composable
fun MandatoryGestureSample() {
    Scaffold(
        topBar = {
            SampleTopBar(
                titleRes = R.string.insets_sample_gesture_mandatory
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(
                        WindowInsets.mandatorySystemGestures.only(WindowInsetsSides.Bottom).union(
                            WindowInsets.navigationBars.only(WindowInsetsSides.Horizontal)
                        )
                    ),
                color = Color.LightGray.copy(alpha = 0.3f)
            ) {
                SampleMediaPlayer(
                    durationSeconds = 600L,
                    title = "Insets",
                    artist = "Margin & Padding"
                )
            }
        }
    }
}

@Preview
@Composable
fun MandatoryGestureSamplePreview() {
    MandatoryGestureSample()
}