package com.kemanci.yummyfood.ui.signin_fragment

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.kemanci.yummyfood.databinding.SigninFragmentBinding
import com.kemanci.yummyfood.utils.Common.Companion.isEmailValid
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
        binding.signupButton.setOnClickListener{
            alphaAnim(binding.signupButton)
        }
        binding.signinButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()

            errorHandlingForInputLayout(email,password).let {
                if(!it){
                    return@setOnClickListener
                }
            }
            viewModel.login(email = email,password = password).observe(viewLifecycleOwner,{
                when(it.status){
                    Resource.Status.LOADING -> {
                        binding.progressLayout.visibility = View.VISIBLE
                        Log.e("TAG", "onViewCreated: Bekliyoruz")
                    }
                    Resource.Status.SUCCESS -> {
                        binding.progressLayout.visibility = View.GONE
                        Log.e("TAG", "onViewCreated: Başarılı" )
                        print(it.data.toString())
                    }
                    Resource.Status.ERROR -> {
                        binding.progressLayout.visibility = View.GONE
                        Log.e("TAG", "onViewCreated: Başarısız" + it.message)
                    }
                }
            })
        }
    }

    fun errorHandlingForInputLayout(email:String,password:String):Boolean{

        var result:Boolean = true
        if(!isEmailValid(email)){
            binding.emailInputLayout.error = "Lütfen email adresinizi doğru giriniz"
            result = false
        }
        if(password.isBlank()){
            binding.passwordInputLayout.error = "Lütfen parolanızı giriniz"
            result = false
        }
        !result && Handler().postDelayed({
            binding.passwordInputLayout.error = ""
            binding.emailInputLayout.error = ""
        },2000)

        return result
    }
    fun alphaAnim(view:View){
        view.alpha = 0.4f
        view.animate()!!.alpha(1f).setDuration(500).start()
    }


}