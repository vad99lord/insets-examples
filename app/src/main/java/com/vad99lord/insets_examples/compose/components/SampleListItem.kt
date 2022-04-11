package com.vad99lord.insets_examples.compose.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.ListItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.vad99lord.insets_examples.compose.data.ListItem

@ExperimentalMaterialApi
@Composable
fun SampleListItem(listItem: ListItem) {
    ListItem(
        icon = { Icon(listItem.icon, null) },
        text = { Text(listItem.title) },
        modifier = Modifier.fillMaxWidth()
    )
}