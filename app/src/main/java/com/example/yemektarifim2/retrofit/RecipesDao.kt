package com.example.yemektarifim2.retrofit

import com.example.yemektarifim2.data.entity.CRUDResponse
import com.example.yemektarifim2.data.entity.Recipe
import com.example.yemektarifim2.data.entity.RecipeDetailResponse
import com.example.yemektarifim2.data.entity.RecipeResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import javax.inject.Singleton

@Singleton
interface RecipesDao {

        @GET("recipes/get_recipes.php")
        fun daoAllRecipes(): Call<RecipeResponse>



        @POST("recipes/update_recipe.php")
        fun daoUpdateRecipe(@Body request: Recipe): Call<CRUDResponse>



        @GET("recipes/get_recipe_detail.php")
        fun daoGetRecipeDetail(@Query("id") id: Int): Call<RecipeDetailResponse>



        @POST("recipes/add_recipe.php")
        fun daoAddRecipe(@Body request:Recipe): Call<CRUDResponse>



        @GET("recipes/search_recipe.php")
        fun daoSearchRecipe(@Query("query") query: String): Call<RecipeResponse>

    }