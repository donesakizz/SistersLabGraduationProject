package com.example.yemektarifim2.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.yemektarifim2.data.entity.Recipe
import com.example.yemektarifim2.databinding.CardDesignBinding
import com.example.yemektarifim2.ui.fragment.HomeFragmentDirections
import com.example.yemektarifim2.ui.viewmodel.HomeViewModel
import com.example.yemektarifim2.util.makeTransition

class RecipesAdapter(var mContext: Context,
                     var recipesList:List<Recipe>,
                     var viewModel: HomeViewModel)
    : RecyclerView.Adapter<RecipesAdapter.CardDesignHolder>(){

    inner class CardDesignHolder(design: CardDesignBinding) : RecyclerView.ViewHolder(design.root) {

        var design: CardDesignBinding

        init {
            this.design= design
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipesAdapter.CardDesignHolder {
        val layoutInflater = LayoutInflater.from(mContext)
        val design = CardDesignBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardDesignHolder(design)
    }

    override fun getItemCount(): Int {
        return recipesList.size
    }

    override fun onBindViewHolder(holder: RecipesAdapter.CardDesignHolder, position: Int) {
        val recipe = recipesList.get(position)

        val t = holder.design


        t.textViewRecipeInfo.text= "${recipe.id}- ${recipe.name}"


        t.satirCard.setOnClickListener {
            Log.e ("Recipe Adapter", "satırCard tıklandı")
            val passing = HomeFragmentDirections.actionHomeFragmentToRecipeDetailFragment(id = recipe.id)
            Navigation.makeTransition(passing,it)
            Log.e ("Recipe Adapter", "id nesnesi gönderildi")
            //putekstra ie recipe yi recipeFragment a gönder

        }
        holder.design.updateImage.setOnClickListener {
            val passing = HomeFragmentDirections.actionHomeFragmentToRecipeUpdateFragment(recipeId = recipe.id )
            Navigation.makeTransition(passing,it)
        }// buradan güncelleme ekranına gönderdin ve güncellemeden de repository classına göndereceksin

        t.deleteImage.setOnClickListener{

            Toast.makeText(mContext,"${recipe.name} Silinemez", Toast.LENGTH_LONG).show()
        }


    }
}


