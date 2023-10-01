package com.example.yemektarifim2.retrofit

class ApiUtils {

    companion object{
        val BASE_URL="https://api.canerture.com/"
        fun getYemeklerDao(): RecipesDao{
            return RetrofitClient.getClient(BASE_URL).create(RecipesDao::class.java)
        }
    }
}