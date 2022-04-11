package com.vad99lord.insets_examples.compose.samples

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.vad99lord.insets_examples.R

abstract class BaseInsetSampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Insetsexamples_NoActionBar)
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setupOnCreate()
        setContent {
            Sample()
        }
    }

    open fun setupOnCreate() {}

    @Composable
    abstract fun Sample()
}