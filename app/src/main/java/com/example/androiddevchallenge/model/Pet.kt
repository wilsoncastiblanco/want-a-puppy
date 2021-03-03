package com.example.androiddevchallenge.model

import android.os.Parcelable
import androidx.compose.runtime.Immutable
import kotlinx.parcelize.Parcelize

@Parcelize
@Immutable
data class Pet(
    val id: Long,
    val name: String,
    val gender: Gender,
    val images: List<String>,
    val type: PetType,
    val age: Int,
    val size: Size
) : Parcelable

enum class PetType {
    DOG, CAT, RABBIT, HAMSTER, PIG
}

enum class Gender {
    MALE, FEMALE
}

enum class Size {
    SMALL, MEDIUM, BIG
}