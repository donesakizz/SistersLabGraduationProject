package com.example.yemektarifim2.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemektarifim2.data.entity.Recipe
import com.example.yemektarifim2.data.repo.RecipeDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor (var repo : RecipeDaRepository): ViewModel(){

    var recipeDetail= MutableLiveData<Recipe>()
    init {
        recipeDetail= repo.repoReturnRecipeDetail()
    }
    fun modelGetRecipeDetail(id:Int) {
        Log.d("RecipeFragment", "getRecipeDetail() function called")
        repo.repoGetRecipeDetail(id)
    }
}