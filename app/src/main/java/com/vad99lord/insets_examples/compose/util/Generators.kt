package com.vad99lord.insets_examples.compose.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import com.vad99lord.insets_examples.compose.data.ListItem


fun generateRandomListItem(): ListItem {
    val message = listOf(
        "System Window Insets",
        "Stable Insets",
        "Display Cutout",
        "Gesture Insets",
        "Mandatory Gesture Insets",
    ).random()
    val icon = sampleIcons.random()
    return ListItem(message, icon)
}

private val sampleIcons = listOf(
    Icons.Default.AddCircle,
    Icons.Default.Share,
    Icons.Default.ArrowDropDown,
    Icons.Default.Notifications,
    Icons.Default.Close
)