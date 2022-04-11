package com.vad99lord.insets_examples.compose.samples.basic_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.windowInsetsBottomHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ui.Scaffold
import com.vad99lord.insets_examples.R
import com.vad99lord.insets_examples.compose.components.SampleTopBar
import com.vad99lord.insets_examples.compose.data.ListItem
import com.vad99lord.insets_examples.compose.utils.generateList
import com.vad99lord.insets_examples.compose.utils.generateRandomListItems
import com.vad99lord.insets_examples.compose.utils.randomListItem

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListSample(
    listItems: List<ListItem> = generateRandomListItems()
) {
    Scaffold(
        topBar = {
            // TopAppBar insets-ui provides passing
            // content padding matching insets.
            SampleTopBar(
                titleRes = R.string.insets_sample_list,
                backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.95f),
            )
        },
        bottomBar = {
            // We add a spacer as a bottom bar, which is the same height as
            // the navigation bar
            Spacer(
                Modifier
                    .windowInsetsBottomHeight(WindowInsets.navigationBars)
                    .fillMaxWidth()
            )
        }
    ) { contentPadding ->
        Box {
            // We apply the contentPadding passed to us from the Scaffold
            LazyColumn(
                contentPadding = contentPadding,
                modifier = Modifier.fillMaxSize(),
            ) {
                items(items = listItems) { listItem ->
                    ListItem(
                        icon = { Icon(listItem.icon, null) },
                        text = { Text(listItem.title) },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}