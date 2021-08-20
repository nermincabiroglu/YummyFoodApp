package com.kemanci.yummyfood.model

import com.kemanci.yummyfood.model.entity.Account
import com.kemanci.yummyfood.model.entity.LoginRequest
import com.kemanci.yummyfood.model.local.LocalDataSource
import com.kemanci.yummyfood.model.remote.RemoteDataSource
import com.kemanci.yummyfood.utils.performNetworkOperation
import javax.inject.Inject

class ApiRepository @Inject constructor(
    private var remoteDataSource: RemoteDataSource,
    private var localDataSource: LocalDataSource
    ) {

    fun login(loginRequest: LoginRequest) = performNetworkOperation { remoteDataSource.login(loginRequest) }
    fun signup(account:Account) = performNetworkOperation { remoteDataSource.signup(account) }
    fun profile(token:String) = performNetworkOperation { remoteDataSource.profile(token = "Bearer ".plus(token)) }
    fun deleteAccount(id:String) = performNetworkOperation { remoteDataSource.deleteAccount(id) }
}