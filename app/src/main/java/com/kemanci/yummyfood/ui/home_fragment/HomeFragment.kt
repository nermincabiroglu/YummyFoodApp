package com.kemanci.yummyfood.ui.home_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kemanci.yummyfood.databinding.HomeFragmentBinding
import com.kemanci.yummyfood.model.entity.AccountResponse

class HomeFragment : Fragment() {
    private lateinit var accountResponse:AccountResponse
    private lateinit var binding:HomeFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  HomeFragmentBinding.inflate(layoutInflater,container,false)
        //accountResponse =  HomeFragmentA.fromBundle(requireArguments()).token
        //SigninFragmentArgs.
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}