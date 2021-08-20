package com.kemanci.yummyfood.model.remote

import com.kemanci.yummyfood.model.entity.Account
import com.kemanci.yummyfood.model.entity.AccountResponse
import com.kemanci.yummyfood.model.entity.LoginRequest
import retrofit2.Response
import retrofit2.http.*
import java.util.*

interface ApiService {

    @GET("account/login")
    suspend fun login(@Body() loginRequest: LoginRequest):Response<AccountResponse>

    @POST("account")
    suspend fun signup(@Body() account:Account):Response<Account>

    @GET("account/profile")
    suspend fun profile(@Header("Authorization") token:String):Response<Account>

    // todo: checkpoint
    @DELETE("account")
    suspend fun deleteAccount(@Path("id") id:String):Response<Objects>
}