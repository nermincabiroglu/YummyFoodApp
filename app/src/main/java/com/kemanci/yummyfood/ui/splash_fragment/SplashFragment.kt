package com.kemanci.yummyfood.ui.splash_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.kemanci.yummyfood.databinding.SplashFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment:Fragment() {
    private lateinit var binding: SplashFragmentBinding
    private val viewModel:SplashViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  SplashFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        viewModel.handleAppLaunch()
    }

    private fun setObservers() {
        val token:String? = viewModel.getToken()
        Log.e("TOKEN", "setObservers: "+ token)
        if(token.isNullOrBlank()) {
            findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToSigninFragment())
            return
        }
        viewModel.isFirstLaunch().observe(viewLifecycleOwner, {
            if (it != null) {
                when(it) {
                    true -> {
                        findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToOnboardingFragment())
                        viewModel.saveFirstLaunch()
                    }
                    else -> findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToSigninFragment())
                }
                viewModel.navigationDone()
            }
        })
    }


}