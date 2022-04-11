package com.vad99lord.insets_examples.compose.samples.fullscreen

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ui.Scaffold
import com.vad99lord.insets_examples.R
import com.vad99lord.insets_examples.compose.components.FullscreenImage
import com.vad99lord.insets_examples.compose.components.SampleTopBar
import com.vad99lord.insets_examples.compose.utils.StableStatusBarsInsetsHolder
import kotlinx.coroutines.flow.StateFlow

@Composable
fun FullscreenStableSample(
    toggleUi: () -> Unit,
    isSystemUiVisible: StateFlow<Boolean>
) {
    val stableInsetsHolder = remember { StableStatusBarsInsetsHolder() }
    val systemUiVisibleState = isSystemUiVisible.collectAsState()
    Scaffold(
        topBar = {
            if (systemUiVisibleState.value) {
                SampleTopBar(
                    titleRes = R.string.insets_sample_fullscreen_stable,
                    contentPadding = stableInsetsHolder.stableStatusBars
                        .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                        .asPaddingValues(),

                    )
            }
        },
        bottomBar = {
            Spacer(
                Modifier
                    .navigationBarsPadding()
                    .fillMaxWidth()
            )
        }
    ) { contentPadding ->
        val interactionSource = remember { MutableInteractionSource() }
        Column(
            Modifier.padding(contentPadding)
        ) {
            FullscreenImage(
                interactionSource = interactionSource,
                onClick = toggleUi
            )
        }
    }
}