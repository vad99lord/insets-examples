package com.vad99lord.insets_examples.adapter

import androidx.recyclerview.widget.DiffUtil
import com.vad99lord.insets_examples.data.InsetsSample

class InsetsSamplesDiffCallback : DiffUtil.ItemCallback<InsetsSample>() {
    override fun areItemsTheSame(oldItem: InsetsSample, newItem: InsetsSample): Boolean {
        return oldItem.javaClass == newItem.javaClass
    }

    override fun areContentsTheSame(oldItem: InsetsSample, newItem: InsetsSample): Boolean {
        return oldItem == newItem
    }
}
