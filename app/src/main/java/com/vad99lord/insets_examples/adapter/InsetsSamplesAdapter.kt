package com.vad99lord.insets_examples.adapter

import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.vad99lord.insets_examples.adapter.delegates.InsetsSampleItemDelegate
import com.vad99lord.insets_examples.data.InsetsSample

fun InsetsSamplesAdapter(onItemClick: (InsetsSample) -> Unit) =
    ListDelegationAdapter(
        InsetsSampleItemDelegate(onItemClick)
    )
