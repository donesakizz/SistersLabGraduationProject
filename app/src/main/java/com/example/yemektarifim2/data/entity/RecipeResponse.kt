package com.example.yemektarifim2.data.entity

import com.google.gson.annotations.SerializedName

data class RecipeResponse (@SerializedName("recipes") var recipes:List<Recipe>,
                           @SerializedName("status") var status:Int,
                           @SerializedName("message") var message:String){
}