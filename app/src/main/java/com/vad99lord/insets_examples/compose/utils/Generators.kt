package com.vad99lord.insets_examples.compose.utils

import androidx.compose.ui.graphics.Color
import com.vad99lord.insets_examples.compose.data.ListItem
import com.vad99lord.insets_examples.compose.data.sampleIcons
import com.vad99lord.insets_examples.compose.data.sampleTitles
import kotlin.random.Random


fun <T> generateList(count: Int, generator: () -> T): List<T> {
    return List(count) { generator() }
}

fun randomListItem(): ListItem {
    val title = sampleTitles.random()
    val icon = sampleIcons.random()
    return ListItem(title, icon)
}

fun generateRandomListItems(count: Int = 50): List<ListItem> {
    return generateList(count) {
        randomListItem()
    }
}


fun randomColor(): Color {
    return Color(
        red = Random.nextFloat(),
        green = Random.nextFloat(),
        blue = Random.nextFloat()
    )
}