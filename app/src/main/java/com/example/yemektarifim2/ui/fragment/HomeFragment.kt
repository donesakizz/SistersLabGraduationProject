package com.example.yemektarifim2.ui.fragment

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
//import androidx.recyclerview.widget.LinearLayoutManager
import com.example.yemektarifim2.R
import com.example.yemektarifim2.databinding.FragmentHomeBinding
import com.example.yemektarifim2.ui.adapter.RecipesAdapter
import com.example.yemektarifim2.ui.viewmodel.HomeViewModel
import com.example.yemektarifim2.util.makeTransition
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() ,SearchView.OnQueryTextListener{
    private lateinit var binding: FragmentHomeBinding

    private lateinit var viewModel: HomeViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding =FragmentHomeBinding.inflate(inflater,container,false)
       // binding.passingAnimationLayout.visibility=View.INVISIBLE
        binding.toolbarHomepage.title = "Tariflerim"
        (activity as AppCompatActivity).setSupportActionBar(binding.toolbarHomepage)

         //binding.rv.layoutManager= LinearLayoutManager(requireContext())
        viewModel.recipesList.observe(viewLifecycleOwner){
            if(it!=null){
                val adapter = RecipesAdapter(requireContext(),it,viewModel)
                binding.rv.adapter = adapter
            }else {
                Snackbar.make(requireView(),"liste boş", Snackbar.LENGTH_SHORT).show()
            }
        }

        binding.fab.setOnClickListener{
            binding.recipesLayout.visibility=View.INVISIBLE
            Navigation.makeTransition(R.id.action_homeFragment_to_recipeAddFragment,it)
        }


        requireActivity().addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu)
                val item=menu.findItem(R.id.action_search)
                val searchView=item.actionView as SearchView
                searchView.setOnQueryTextListener(this@HomeFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        },viewLifecycleOwner, Lifecycle.State.RESUMED)
        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : HomeViewModel by viewModels ()
        viewModel = tempViewModel
    }


    override fun onResume() {
        super.onResume()
        viewModel.modelLoadRecipes()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        viewModel.modelSearch(query.toString())
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        viewModel.modelSearch(newText.toString())
        return true
    }

}




