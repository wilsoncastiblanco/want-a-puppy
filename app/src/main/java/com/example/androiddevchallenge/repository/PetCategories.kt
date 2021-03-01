package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.PetCategory
import com.example.androiddevchallenge.model.PetType


val petCategories: List<PetCategory> = listOf(
    PetCategory(
        id = 1L,
        name = "Dogs",
        icon = PetIcon.dog,
        type = PetType.DOG
    ),
    PetCategory(
        id = 2L,
        name = "Cats",
        icon = PetIcon.cat,
        type = PetType.CAT
    ),
    PetCategory(
        id = 4L,
        name = "Hamster",
        icon = PetIcon.mouse,
        type = PetType.HAMSTER
    ),
    PetCategory(
        id = 5L,
        name = "Rabbits",
        icon = PetIcon.rabbit,
        type = PetType.RABBIT
    ),
)

object PetIcon {
    const val dog = R.drawable.ic_dog
    const val cat = R.drawable.ic_cat
    const val mouse = R.drawable.ic_mouse
    const val rabbit = R.drawable.ic_rabbit
}