package com.example.androiddevchallenge.model

import androidx.compose.runtime.Immutable

@Immutable
data class Pet(
    val id: Long,
    val name: String,
    val gender: Gender,
    val images: List<String>,
    val type: PetType,
    val age: Int
)

enum class PetType {
    DOG, CAT, RABBIT, HAMSTER
}

enum class Gender {
    MALE, FEMALE
}