package com.example.androiddevchallenge.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PetForAdoption(
    val id: Long,
    val pet: Pet,
    val location: String,
    val description: String
) : Parcelable
