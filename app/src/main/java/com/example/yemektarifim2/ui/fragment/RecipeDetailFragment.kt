package com.example.yemektarifim2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.yemektarifim2.R
import com.example.yemektarifim2.databinding.FragmentRecipeDetailBinding
import com.example.yemektarifim2.ui.viewmodel.DetailViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeDetailFragment : Fragment() {

    private lateinit var design: FragmentRecipeDetailBinding
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        design = FragmentRecipeDetailBinding.inflate(inflater,container,false)

        val bundle: RecipeDetailFragmentArgs by navArgs()
        val getRecipe = bundle.id

        val recipeId = getRecipe
        viewModel.modelGetRecipeDetail(recipeId)


        viewModel.recipeDetail.observe(viewLifecycleOwner){ recipeDetail->//Recipe type
            //bu kısım eğer birden fazla detay gelirse?

            // design.recipeDetailIdName.text= "${recipeDetail.id} - ${recipeDetail.name}"
            design.toolbar.title= "${recipeDetail.id}-${recipeDetail.name}"
            design.recipeDetailDescription.text=  recipeDetail.description

        }
        //  design.recipeDetailDescription.text=  viewModel.modelGetRecipeDetail(recipeId)

        return design.root
    }


}