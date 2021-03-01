package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable

@Composable
fun Search(
    onPuppyClick: (Long) -> Unit,
) {
    Column {
        SearchBar()
    }
}

@Composable
fun SearchBar(

) {
    Surface(
        shape = MaterialTheme.shapes.small,
    ) {

    }
}