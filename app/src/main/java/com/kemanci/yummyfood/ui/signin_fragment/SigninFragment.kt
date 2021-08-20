package com.kemanci.yummyfood.ui.signin_fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kemanci.yummyfood.databinding.SigninFragmentBinding
import com.kemanci.yummyfood.utils.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SigninFragment: Fragment() {
    private lateinit var binding: SigninFragmentBinding
    private val viewModel:SigninViewModel by viewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =  SigninFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.signinButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            viewModel.login(email = email,password = password).observe(viewLifecycleOwner,{
                when(it.status){
                    Resource.Status.LOADING -> Log.e("TAG", "onViewCreated: Bekliyoruz" )
                    Resource.Status.SUCCESS -> {
                        Log.e("TAG", "onViewCreated: Başarılı" )
                        print(it.data.toString())
                    }
                    Resource.Status.ERROR -> Log.e("TAG", "onViewCreated: Başarısız" )
                }
            })
            /*viewModel.profile("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJlbWFpbCI6Im1obXRAZGVtb2dsdS5jb20iLCJwYXNzd29yZCI6ImRlbmVtZTEyMyIsImlhdCI6MTYyOTQxNzc3MH0.GBGiMEak_Wzg_7us8tpufWaMIwx_5IMXpCBDmNDQ1OM").observe(viewLifecycleOwner,{
                when(it.status){
                    Resource.Status.LOADING -> Log.e("TAG", "onViewCreated:Bekliyor"+it.message )
                    Resource.Status.SUCCESS -> {
                        Log.e("TAG", "onViewCreated: Başarılı işte"+it.message)
                    }
                    Resource.Status.ERROR -> Log.e("TAG", "onViewCreated:Başarısız"+it.message )
                }
            })*/
        }
    }
}