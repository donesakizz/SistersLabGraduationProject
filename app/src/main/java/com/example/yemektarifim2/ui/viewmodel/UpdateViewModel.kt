package com.example.yemektarifim2.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemektarifim2.data.entity.Recipe
import com.example.yemektarifim2.data.repo.RecipeDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UpdateViewModel @Inject constructor (var repo : RecipeDaRepository): ViewModel() {
    var recipeDetail= MutableLiveData<Recipe>()
    init {
        recipeDetail= repo.repoReturnRecipeDetail()
    }
    fun modelDetail(id:Int){
        repo.repoGetRecipeDetail(id)
    }
    fun modelUpdate(request: Recipe){
        repo.repoUpdateRecipes(request)
    }
}