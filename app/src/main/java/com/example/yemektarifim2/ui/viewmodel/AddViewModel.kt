package com.example.yemektarifim2.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.yemektarifim2.data.entity.Recipe
import com.example.yemektarifim2.data.repo.RecipeDaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(var repo : RecipeDaRepository): ViewModel() {
    fun modelAdd(request: Recipe){
        repo.repoAddRecipe(request)
    }
}