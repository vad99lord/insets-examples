package com.vad99lord.insets_examples.compose.samples.fullscreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import coil.compose.rememberAsyncImagePainter
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import com.vad99lord.insets_examples.R
import com.vad99lord.insets_examples.compose.components.ColoredBox
import com.vad99lord.insets_examples.compose.util.StableStatusBarsInsetsHolder
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
                TopAppBar(
                    title = { Text(stringResource(R.string.insets_sample_fullscreen_stable)) },
                    backgroundColor = MaterialTheme.colors.surface,
                    contentPadding = stableInsetsHolder.stableStatusBars
                        .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                        .asPaddingValues(),
                    modifier = Modifier.fillMaxWidth(),
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
            Image(
                painter = rememberAsyncImagePainter(
                    model = R.drawable.ic_sample_image,
                    contentScale = ContentScale.Crop
                ),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = { toggleUi() },
                    )
            )
            ColoredBox(
                modifier = Modifier
                    .fillMaxSize()
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        onClick = { toggleUi() },
                    ),
                color = MaterialTheme.colors.secondary
            )
        }
    }
}