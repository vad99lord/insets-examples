package com.vad99lord.insets_examples.compose.samples.keyboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import com.google.accompanist.insets.ExperimentalAnimatedInsets
import com.google.accompanist.insets.rememberImeNestedScrollConnection
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import com.vad99lord.insets_examples.R
import com.vad99lord.insets_examples.compose.components.BottomEditText
import com.vad99lord.insets_examples.compose.components.SampleListItem
import com.vad99lord.insets_examples.compose.data.ListItem
import com.vad99lord.insets_examples.compose.utils.generateRandomListItems

@OptIn(ExperimentalAnimatedInsets::class, ExperimentalMaterialApi::class)
@Composable
fun KeyboardScrollImeSample(
    listItems: List<ListItem> = generateRandomListItems()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(R.string.insets_sample_keyboard_scroll)) },
                backgroundColor = MaterialTheme.colors.surface,
                contentPadding = WindowInsets.statusBars
                    .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
                    .asPaddingValues(),
                modifier = Modifier.fillMaxWidth(),
            )
        },
        bottomBar = {
            BottomEditText()
        },
        modifier = Modifier.fillMaxSize()
    ) { contentPadding ->
        Column {
            LazyColumn(
                contentPadding = contentPadding,
                reverseLayout = true,
                modifier = Modifier
                    .weight(1f)
                    .nestedScroll(connection = rememberImeNestedScrollConnection())
            ) {
                items(listItems) { SampleListItem(it) }
            }
        }
    }
}