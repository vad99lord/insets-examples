package com.vad99lord.insets_examples.adapter.delegates

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import com.vad99lord.insets_examples.data.InsetsSample
import com.vad99lord.insets_examples.databinding.InsetsSampleListItemBinding

fun InsetsSampleItemDelegate(onItemClick: (InsetsSample) -> Unit) =
    adapterDelegateViewBinding<InsetsSample, InsetsSample, InsetsSampleListItemBinding>(
        viewBinding = { layoutInflater, root ->
            InsetsSampleListItemBinding.inflate(
                layoutInflater,
                root,
                false
            )
        },
    ) {
        binding.root.setOnClickListener {
            onItemClick(item)
        }
        bind {
            binding.titleTextView.text = getString(item.titleRes)
        }
    }
