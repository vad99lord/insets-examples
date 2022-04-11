package com.vad99lord.insets_examples.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.mandatorySystemGestures
import androidx.compose.foundation.layout.mandatorySystemGesturesPadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
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

@Composable
fun GestureSample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.insets_sample_gesture)) },
                backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.95f),
                contentPadding = WindowInsets.statusBars
                    .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                    .asPaddingValues(),
                modifier = Modifier.fillMaxWidth()
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
                    .windowInsetsPadding(WindowInsets.mandatorySystemGestures.only(WindowInsetsSides.Bottom)),
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
fun GestureSamplePreview() {
    GestureSample()
}