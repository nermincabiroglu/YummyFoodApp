package com.kemanci.yummyfood.model.entity

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Restaurant(
    @SerializedName("_id")
    var _id:String,

    @SerializedName("name")
    var name:String,

    @SerializedName("phone_number")
    var phone_number:String,

    @SerializedName("address")
    var address:String,

    @SerializedName("point")
    var point:Double,

    @SerializedName("average_delivery_time")
    var average_delivery_time:Int,

    @SerializedName("menu")
    var menu:ArrayList<Food>,

    @SerializedName("image_url")
    var image_url:String,

    @SerializedName("county")
    var county:String,

    @SerializedName("province")
    var province:String,

    @SerializedName("min_order")
    var min_order:Double,

    @SerializedName("working_start")
    var working_start:String,

    @SerializedName("working_end")
    var working_end:String
):Parcelable