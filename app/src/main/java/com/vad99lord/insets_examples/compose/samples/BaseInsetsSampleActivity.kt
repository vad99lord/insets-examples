package com.vad99lord.insets_examples.compose.samples

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.vad99lord.insets_examples.R
import com.vad99lord.insets_examples.compose.components.TransparentSystemBars

abstract class BaseInsetsSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Insetsexamples_NoActionBar)
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setupOnCreate()
        setContent {
            TransparentSystemBars()
            Sample()
        }
    }

    open fun setupOnCreate() {}

    @Composable
    abstract fun Sample()
}