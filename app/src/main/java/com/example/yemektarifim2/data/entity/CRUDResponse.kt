package com.example.yemektarifim2.data.entity

import com.google.gson.annotations.SerializedName

class CRUDResponse (@SerializedName("status") var status:Int,
                    @SerializedName("message") var message:String){
}