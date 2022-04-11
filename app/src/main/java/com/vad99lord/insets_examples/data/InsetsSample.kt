package com.vad99lord.insets_examples.data

import androidx.annotation.StringRes
import com.vad99lord.insets_examples.R

sealed class InsetsSample(
    @StringRes open val titleRes: Int
) {
    sealed class Fullscreen(@StringRes override val titleRes: Int) : InsetsSample(titleRes) {
        object Stable : Fullscreen(R.string.insets_sample_fullscreen_stable)
        object Cutout : Fullscreen(R.string.insets_sample_fullscreen_cutout)
    }

    sealed class Gesture(@StringRes override val titleRes: Int) : InsetsSample(titleRes) {
        object Mandatory : Gesture(R.string.insets_sample_gesture_mandatory)
        object Exclusion : Gesture(R.string.insets_sample_gesture_exclusion)
    }

    sealed class Keyboard(@StringRes override val titleRes: Int) : InsetsSample(titleRes) {
        object BasicIme : Keyboard(R.string.insets_sample_keyboard_basic)
        object ScrollIme : Keyboard(R.string.insets_sample_keyboard_scroll)
    }

    object BasicList : InsetsSample(R.string.insets_sample_list)
}

val insetsSamples = listOf(
    InsetsSample.BasicList,
    InsetsSample.Keyboard.BasicIme,
    InsetsSample.Keyboard.ScrollIme,
    InsetsSample.Fullscreen.Cutout,
    InsetsSample.Fullscreen.Stable,
    InsetsSample.Gesture.Mandatory,
    InsetsSample.Gesture.Exclusion,
)