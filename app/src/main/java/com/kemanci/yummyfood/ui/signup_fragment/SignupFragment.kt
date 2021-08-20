package com.kemanci.yummyfood.ui.signup_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kemanci.yummyfood.databinding.SigninFragmentBinding
import com.kemanci.yummyfood.databinding.SignupFragmentBinding

class SignupFragment : Fragment() {
    private lateinit var binding: SignupFragmentBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  SignupFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}