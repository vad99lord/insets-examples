package com.vad99lord.insets_examples.compose.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.google.accompanist.insets.ui.TopAppBar

@Composable
fun SampleTopBar(
    @StringRes titleRes: Int,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.surface,
    contentPadding: PaddingValues = WindowInsets.statusBars
        .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
        .asPaddingValues(),
) {
    TopAppBar(
        title = {
            Text(stringResource(titleRes))
        },
        backgroundColor = backgroundColor,
        contentPadding = contentPadding,
        modifier = modifier.fillMaxWidth()
    )
}