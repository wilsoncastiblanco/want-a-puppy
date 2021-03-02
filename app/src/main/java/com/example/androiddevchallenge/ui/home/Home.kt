package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.model.PetForAdoption

@Composable
fun Home(petSelected: (PetForAdoption) -> Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Column {
            CategoriesList(onCategoryClick = { /*TODO*/ })
            PetsCollection(onPetClick = petSelected)
        }
    }
}