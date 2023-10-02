package com.example.yemektarifim2.ui.fragment

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.yemektarifim2.R
import com.example.yemektarifim2.data.entity.Recipe
import com.example.yemektarifim2.databinding.FragmentRecipeAddBinding
import com.example.yemektarifim2.ui.viewmodel.AddViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeAddFragment : Fragment() {

    private lateinit var binding: FragmentRecipeAddBinding
    private lateinit var viewModel: AddViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding = FragmentRecipeAddBinding.inflate(inflater,container,false)
        binding.toolbarRecipeAdd.title = "Tarif ekle"

        binding.buttonAdd.setOnClickListener {

            val alert = AlertDialog.Builder(requireContext())
            alert.setTitle("Ekleme")

            val recipeName=binding.editTextRecipeName.text?.trim().toString()
            val recipeDescription=binding.editTextRecipeDiscription.text?.trim().toString()

            if(!recipeName.equals("") && !recipeDescription.equals("") ) {
                alert.setMessage("${recipeName.uppercase()} eklensin mi ?")

                alert.setPositiveButton("EVET") { dialog, which ->

                    val recipe = Recipe(0, recipeName, recipeDescription)
                    add(recipe)

                    Toast.makeText(
                        requireContext(),
                        "${recipeName.uppercase()} Eklendi",
                        Toast.LENGTH_LONG
                    ).show()
                }

                alert.setNegativeButton("HAYIR") { dialog, which ->
                    Toast.makeText(
                        requireContext(),
                        "${recipeName.uppercase()} Eklenmedi",
                        Toast.LENGTH_LONG
                    ).show()
                }
                alert.show()
            } else {
                Toast.makeText(requireContext(),"Alanlar Boş Geçilemez", Toast.LENGTH_LONG).show()
            }
        }



        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : AddViewModel by viewModels()
        viewModel = tempViewModel
    }

    //Bu metot, viewModel üzerinden modelAdd() fonksiyonunu çağırarak bir tarifi eklemek için kullanılır.
    // Bu metot, Recipe nesnesini parametre olarak alır ve bu nesneyi ViewModel'deki ilgili fonksiyona geçer.
    fun add(request: Recipe){
        viewModel.modelAdd(request)
    }


}