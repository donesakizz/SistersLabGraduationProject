package com.example.yemektarifim2.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.makeTransition(id:Int, it: View){
    findNavController(it).navigate(id)
}
fun Navigation.makeTransition(id: NavDirections, it: View){
    findNavController(it).navigate(id)
}