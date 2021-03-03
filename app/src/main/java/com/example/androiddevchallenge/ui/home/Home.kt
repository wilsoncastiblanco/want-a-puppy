package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.PetForAdoption

@Composable
fun Home(petSelected: (PetForAdoption) -> Unit) {
    Surface(color = MaterialTheme.colors.background, modifier = Modifier.padding(12.dp)) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(id = R.string.title_home),
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(4.dp),
            )
            Spacer(Modifier.height(8.dp))
            SearchBar()
            Spacer(Modifier.height(8.dp))
            CategoriesList(onCategoryClick = { /*TODO*/ })
            Spacer(Modifier.height(8.dp))
            PetsCollection(onPetClick = petSelected)
        }
    }
}