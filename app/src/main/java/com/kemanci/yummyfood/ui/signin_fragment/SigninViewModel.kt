package com.kemanci.yummyfood.ui.signin_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.kemanci.yummyfood.model.ApiRepository
import com.kemanci.yummyfood.model.entity.Account
import com.kemanci.yummyfood.model.entity.AccountResponse
import com.kemanci.yummyfood.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SigninViewModel @Inject constructor(private val apiRepository: ApiRepository):ViewModel(){
    fun login(email:String,password:String):LiveData<Resource<AccountResponse>>{
        return apiRepository.login(email, password)
    }
    fun profile(token:String):LiveData<Resource<Account>>{
        return  apiRepository.profile(token)
    }
}