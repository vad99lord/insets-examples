package com.vad99lord.insets_examples.compose.samples.fullscreen

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ui.Scaffold
import com.vad99lord.insets_examples.compose.components.FullscreenImage

@Composable
fun FullscreenCutoutSample(
    toggleUi: () -> Unit
) {
    Scaffold(
        topBar = {
            Spacer(
                Modifier
                    .statusBarsPadding()
                    .fillMaxWidth()
            )
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