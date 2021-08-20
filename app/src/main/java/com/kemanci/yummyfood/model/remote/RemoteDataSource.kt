package com.kemanci.yummyfood.model.remote

import com.kemanci.yummyfood.model.entity.Account
import com.kemanci.yummyfood.model.entity.LoginRequest
import com.kemanci.yummyfood.utils.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) : BaseDataSource(){
    suspend fun login(loginRequest: LoginRequest) = getResult { apiService.login(loginRequest) }
    suspend fun signup(account: Account) = getResult { apiService.signup(account = account) }
    suspend fun profile(token:String) = getResult { apiService.profile(token) }
    suspend fun deleteAccount(id:String) = getResult { apiService.deleteAccount(id) }
}