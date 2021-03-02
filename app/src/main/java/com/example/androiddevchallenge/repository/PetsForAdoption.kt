package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.model.*

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
            images = dogRandomImages,
            size = Size.MEDIUM
        ),
        location = "Ann Arbor",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
    ),
    PetForAdoption(
        id = 2L,
        pet = Pet(
            id = 2L,
            name = "Tonny",
            age = 4,
            type = PetType.DOG,
            gender = Gender.MALE,
            images = dogRandomImages,
            size = Size.BIG
        ),
        location = "Atlanta",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
    ),
    PetForAdoption(
        id = 3L,
        pet = Pet(
            id = 3L,
            name = "Mina",
            age = 6,
            type = PetType.DOG,
            gender = Gender.FEMALE,
            images = dogRandomImages,
            size = Size.SMALL
        ),
        location = "Austin",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
    ),
    PetForAdoption(
        id = 4L,
        pet = Pet(
            id = 4L,
            name = "Sun",
            age = 3,
            type = PetType.DOG,
            gender = Gender.FEMALE,
            images = dogRandomImages,
            size = Size.MEDIUM
        ),
        location = "Boulder",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
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
            images = catRandomImages,
            size = Size.SMALL
        ),
        location = "Boulder - Pearl Place",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
    ),
    PetForAdoption(
        id = 6L,
        pet = Pet(
            id = 6L,
            name = "Azrael",
            age = 5,
            type = PetType.CAT,
            gender = Gender.MALE,
            images = catRandomImages,
            size = Size.SMALL
        ),
        location = "Boulder - Walnut",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
    ),
    PetForAdoption(
        id = 7L,
        pet = Pet(
            id = 7L,
            name = "Kitty",
            age = 3,
            type = PetType.CAT,
            gender = Gender.FEMALE,
            images = catRandomImages,
            size = Size.SMALL
        ),
        location = "Cambridge",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
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
            images = rabbitRandomImages,
            size = Size.SMALL
        ),
        location = "Cambridge",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
    ),
    PetForAdoption(
        id = 9L,
        pet = Pet(
            id = 9L,
            name = "Ry",
            age = 6,
            type = PetType.RABBIT,
            gender = Gender.FEMALE,
            images = rabbitRandomImages,
            size = Size.SMALL
        ),
        location = "Cambridge",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
    ),
    PetForAdoption(
        id = 10L,
        pet = Pet(
            id = 10L,
            name = "Coney",
            age = 1,
            type = PetType.RABBIT,
            gender = Gender.MALE,
            images = rabbitRandomImages,
            size = Size.SMALL
        ),
        location = "Chapel Hill",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
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
            images = hamsterRandomImages,
            size = Size.SMALL
        ),
        location = "Chicago - Carpenter",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
    ),
    PetForAdoption(
        id = 12L,
        pet = Pet(
            id = 12L,
            name = "Cerebro",
            age = 3,
            type = PetType.HAMSTER,
            gender = Gender.MALE,
            images = hamsterRandomImages,
            size = Size.SMALL
        ),
        location = "Chicago - Fulton Market",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
    ),
    PetForAdoption(
        id = 13L,
        pet = Pet(
            id = 13L,
            name = "Misty",
            age = 1,
            type = PetType.HAMSTER,
            gender = Gender.MALE,
            images = hamsterRandomImages,
            size = Size.SMALL
        ),
        location = "Mountain View",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus a cursus eros. Donec at dapibus justo. In blandit, risus eu fringilla viverra, urna urna varius sapien, in euismod sem neque in erat. Suspendisse convallis scelerisque nisi vel mattis. Donec tempus lectus in metus commodo, et pulvinar ipsum pulvinar. "
    ),

)