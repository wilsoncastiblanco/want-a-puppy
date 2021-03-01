package com.example.androiddevchallenge.model

import androidx.compose.runtime.Immutable

@Immutable
data class PetCategory(
    val id: Long,
    val name: String,
    val icon: Int,
    val type: PetType
)