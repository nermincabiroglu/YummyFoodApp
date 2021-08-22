package com.kemanci.yummyfood.ui.restaurant_fragment

import androidx.lifecycle.ViewModel
import com.kemanci.yummyfood.model.ApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantViewModel @Inject constructor(private val apiRepository: ApiRepository):ViewModel() {
}