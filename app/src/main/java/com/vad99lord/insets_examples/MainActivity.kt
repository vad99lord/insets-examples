package com.vad99lord.insets_examples

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.divider.MaterialDividerItemDecoration
import com.vad99lord.insets_examples.adapter.InsetsSamplesAdapter
import com.vad99lord.insets_examples.compose.samples.basic_list.ListSampleActivity
import com.vad99lord.insets_examples.compose.samples.fullscreen.FullscreenCutoutSampleActivity
import com.vad99lord.insets_examples.compose.samples.fullscreen.FullscreenStableSampleActivity
import com.vad99lord.insets_examples.compose.samples.gestures.GestureExclusionSampleActivity
import com.vad99lord.insets_examples.compose.samples.gestures.MandatoryGestureSampleActivity
import com.vad99lord.insets_examples.compose.samples.keyboard.KeyboardBasicImeSampleActivity
import com.vad99lord.insets_examples.compose.samples.keyboard.KeyboardScrollImeSampleActivity
import com.vad99lord.insets_examples.data.InsetsSample
import com.vad99lord.insets_examples.data.insetsSamples
import com.vad99lord.insets_examples.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBinding(ActivityMainBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initList()
    }

    private fun initList() {
        val insetsSamplesAdapter = InsetsSamplesAdapter(::openInsetsSample)
        val divider = MaterialDividerItemDecoration(this, LinearLayoutManager.VERTICAL)
        insetsSamplesAdapter.items = insetsSamples
        with(binding) {
            itemList.adapter = insetsSamplesAdapter
            itemList.addItemDecoration(divider)
        }
    }

    private fun openInsetsSample(sample: InsetsSample) {
        val sampleActivity =
            when (sample) {
                InsetsSample.BasicList -> ListSampleActivity::class
                InsetsSample.Fullscreen.Cutout -> FullscreenCutoutSampleActivity::class
                InsetsSample.Fullscreen.Stable -> FullscreenStableSampleActivity::class
                InsetsSample.Gesture.Exclusion -> GestureExclusionSampleActivity::class
                InsetsSample.Gesture.Mandatory -> MandatoryGestureSampleActivity::class
                InsetsSample.Keyboard.BasicIme -> KeyboardBasicImeSampleActivity::class
                InsetsSample.Keyboard.ScrollIme -> KeyboardScrollImeSampleActivity::class
            }
        val intent = Intent(this, sampleActivity.java)
        startActivity(intent)
    }
}