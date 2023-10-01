package com.example.yemektarifim2.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.yemektarifim2.data.entity.Recipe
import com.example.yemektarifim2.data.repo.RecipeDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(var  repo : RecipeDaRepository) : ViewModel(){
    var recipesList = MutableLiveData<List<Recipe>>()
    init {

        modelLoadRecipes()
        recipesList= repo.repoReturnRecipes()
    }

    fun modelLoadRecipes(){
        repo.repoGetRecipes()
    }

    fun modelSearch(searchWord:String){
        repo.repoSearchRecipe(searchWord)
    }
}