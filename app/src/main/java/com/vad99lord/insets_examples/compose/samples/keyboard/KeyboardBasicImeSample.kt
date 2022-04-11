package com.vad99lord.insets_examples.compose.samples.keyboard

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ui.Scaffold
import com.vad99lord.insets_examples.R
import com.vad99lord.insets_examples.compose.components.BottomEditText
import com.vad99lord.insets_examples.compose.components.SampleListItem
import com.vad99lord.insets_examples.compose.components.SampleTopBar
import com.vad99lord.insets_examples.compose.data.ListItem
import com.vad99lord.insets_examples.compose.utils.generateRandomListItems

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun KeyboardBasicImeSample(
    listItems: List<ListItem> = generateRandomListItems()
) {
    Scaffold(
        topBar = {
            SampleTopBar(
                titleRes = R.string.insets_sample_keyboard_basic
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
            ) {
                items(listItems) { SampleListItem(it) }
            }
        }
    }
}