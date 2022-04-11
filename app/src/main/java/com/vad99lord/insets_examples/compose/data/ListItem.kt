package com.vad99lord.insets_examples.compose.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Share
import androidx.compose.ui.graphics.vector.ImageVector

data class ListItem(
    val title: String,
    val icon: ImageVector
)

val sampleTitles = listOf(
    "System Window Insets",
    "Stable Insets",
    "Display Cutout",
    "Gesture Insets",
    "Mandatory Gesture Insets",
    "IME Insets",
)

val sampleIcons = listOf(
    Icons.Default.AddCircle,
    Icons.Default.Share,
    Icons.Default.ArrowDropDown,
    Icons.Default.Notifications,
    Icons.Default.Close
)
