package com.vad99lord.insets_examples

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.vad99lord.insets_examples.databinding.FragmentStartBinding

class StartFragment: Fragment(R.layout.fragment_start) {

    private val viewBinding by viewBinding(FragmentStartBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.composeButton.setOnClickListener{
            val directions = StartFragmentDirections.actionStartFragmentToExampleFragment()
            findNavController().navigate(directions)
        }
    }
}