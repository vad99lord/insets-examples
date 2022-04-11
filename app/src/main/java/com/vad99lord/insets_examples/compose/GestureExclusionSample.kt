package com.vad99lord.insets_examples.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.systemGestureExclusion
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ui.TopAppBar
import com.vad99lord.insets_examples.R
import com.vad99lord.insets_examples.compose.components.BottomSheetIndicator
import com.vad99lord.insets_examples.compose.components.BottomSheetInsetScaffold
import com.vad99lord.insets_examples.compose.components.ColoredBox
import com.vad99lord.insets_examples.compose.util.generateRandomColor

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun GestureExclusionSample() {
    BottomSheetInsetScaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.insets_sample_gesture_exclusion)) },
                contentPadding = WindowInsets.statusBars
                    .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                    .asPaddingValues()
            )
        },
        sheetContent = { height ->
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(height)
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top,
                ) {
                    BottomSheetIndicator()
                }
                Spacer(
                    modifier = Modifier
                        .size(32.dp)
                )
                LazyRow(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .systemGestureExclusion(),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    val gestureInclusiveSize = 200.dp
                    val extraAreaSize = 32.dp
                    item {
                        MatchParentWidthColumn {
                            ColoredBox(
                                modifier = Modifier.fillMaxWidth(),
                                size = extraAreaSize,
                                color = MaterialTheme.colors.surface,
                                border = 2.dp,
                                text = """
                                    Extra 32dp
                                """.trimIndent()
                            )
                            ColoredBox(
                                size = gestureInclusiveSize,
                                color = MaterialTheme.colors.surface,
                                border = 2.dp,
                                text = """
                                    200dp
                                    Gestures doesn't work here
                                    But works in the upper area
                                """.trimIndent()
                            )
                        }
                    }
                    items(items = colorsList) { color ->
                        MatchParentWidthColumn {
                            ColoredBox(
                                modifier = Modifier.fillMaxWidth(),
                                size = extraAreaSize,
                                color = MaterialTheme.colors.error
                            )
                            ColoredBox(
                                size = gestureInclusiveSize,
                                color = color
                            )
                        }
                    }
                }
            }
        }
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            color = MaterialTheme.colors.secondaryVariant
        ) {}
    }
}

@Composable
private fun MatchParentWidthColumn(
    content: @Composable ColumnScope.() -> Unit
) {
    Column(
        Modifier.width(IntrinsicSize.Max),
        content = content
    )
}

private val colorsList = List(50) { generateRandomColor() }

@Preview
@Composable
fun GestureExclusionSamplePreview() {
    GestureExclusionSample()
}