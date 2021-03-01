package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.model.Gender
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.model.PetForAdoption
import com.example.androiddevchallenge.model.PetType

val dogRandomImages = listOf(
    "https://source.unsplash.com/featured/?dog",
    "https://source.unsplash.com/featured/?dog",
    "https://source.unsplash.com/featured/?dog"
)

val catRandomImages = listOf(
    "https://source.unsplash.com/featured/?cat",
    "https://source.unsplash.com/featured/?cat",
    "https://source.unsplash.com/featured/?cat"
)

val rabbitRandomImages = listOf(
    "https://source.unsplash.com/featured/?rabbit",
    "https://source.unsplash.com/featured/?rabbit",
    "https://source.unsplash.com/featured/?rabbit"
)

val hamsterRandomImages = listOf(
    "https://source.unsplash.com/featured/?hamster",
    "https://source.unsplash.com/featured/?hamster",
    "https://source.unsplash.com/featured/?hamster"
)

val petsForAdoption: List<PetForAdoption> = listOf(
    //DOGS
    PetForAdoption(
        id = 1L,
        pet = Pet(
            id = 1L,
            name = "Lucas",
            age = 2,
            type = PetType.DOG,
            gender = Gender.MALE,
            images = dogRandomImages
        ),
        location = "Ann Arbor"
    ),
    PetForAdoption(
        id = 2L,
        pet = Pet(
            id = 2L,
            name = "Tonny",
            age = 4,
            type = PetType.DOG,
            gender = Gender.MALE,
            images = dogRandomImages
        ),
        location = "Atlanta"
    ),
    PetForAdoption(
        id = 3L,
        pet = Pet(
            id = 3L,
            name = "Mina",
            age = 6,
            type = PetType.DOG,
            gender = Gender.FEMALE,
            images = dogRandomImages
        ),
        location = "Austin"
    ),
    PetForAdoption(
        id = 4L,
        pet = Pet(
            id = 4L,
            name = "Sun",
            age = 3,
            type = PetType.DOG,
            gender = Gender.FEMALE,
            images = dogRandomImages
        ),
        location = "Boulder"
    ),
    //CATS
    PetForAdoption(
        id = 5L,
        pet = Pet(
            id = 5L,
            name = "Snow Ball",
            age = 1,
            type = PetType.CAT,
            gender = Gender.FEMALE,
            images = catRandomImages
        ),
        location = "Boulder - Pearl Place"
    ),
    PetForAdoption(
        id = 6L,
        pet = Pet(
            id = 6L,
            name = "Azrael",
            age = 5,
            type = PetType.CAT,
            gender = Gender.MALE,
            images = catRandomImages
        ),
        location = "Boulder - Walnut"
    ),
    PetForAdoption(
        id = 7L,
        pet = Pet(
            id = 7L,
            name = "Kitty",
            age = 3,
            type = PetType.CAT,
            gender = Gender.FEMALE,
            images = catRandomImages
        ),
        location = "Cambridge"
    ),
    //RABBIT
    PetForAdoption(
        id = 8L,
        pet = Pet(
            id = 8L,
            name = "Snowflake",
            age = 3,
            type = PetType.RABBIT,
            gender = Gender.MALE,
            images = rabbitRandomImages
        ),
        location = "Cambridge"
    ),
    PetForAdoption(
        id = 9L,
        pet = Pet(
            id = 9L,
            name = "Ry",
            age = 6,
            type = PetType.RABBIT,
            gender = Gender.FEMALE,
            images = rabbitRandomImages
        ),
        location = "Cambridge"
    ),
    PetForAdoption(
        id = 10L,
        pet = Pet(
            id = 10L,
            name = "Coney",
            age = 1,
            type = PetType.RABBIT,
            gender = Gender.MALE,
            images = rabbitRandomImages
        ),
        location = "Chapel Hill"
    ),
    //HAMSTERS
    PetForAdoption(
        id = 11L,
        pet = Pet(
            id = 11L,
            name = "Pinky",
            age = 4,
            type = PetType.HAMSTER,
            gender = Gender.MALE,
            images = hamsterRandomImages
        ),
        location = "Chicago - Carpenter"
    ),
    PetForAdoption(
        id = 12L,
        pet = Pet(
            id = 12L,
            name = "Cerebro",
            age = 3,
            type = PetType.HAMSTER,
            gender = Gender.MALE,
            images = hamsterRandomImages
        ),
        location = "Chicago - Fulton Market"
    ),
    PetForAdoption(
        id = 13L,
        pet = Pet(
            id = 13L,
            name = "Misty",
            age = 1,
            type = PetType.HAMSTER,
            gender = Gender.MALE,
            images = hamsterRandomImages
        ),
        location = "Mountain View"
    ),

)