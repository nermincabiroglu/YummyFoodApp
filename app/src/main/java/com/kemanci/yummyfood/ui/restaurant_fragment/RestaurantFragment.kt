package com.kemanci.yummyfood.ui.restaurant_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kemanci.yummyfood.databinding.RestaurantFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantFragment:Fragment() {
    private lateinit var binding: RestaurantFragmentBinding
    private val viewModel:RestaurantViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}