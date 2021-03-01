package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Gender
import com.example.androiddevchallenge.model.PetForAdoption
import com.example.androiddevchallenge.repository.petsForAdoption
import com.example.androiddevchallenge.ui.theme.MyTheme
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetsCollection(
    onPetClick: (PetForAdoption) -> Unit
) {
    Column {
        Text(
            text = stringResource(R.string.title_pets),
            color = Color.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Pets(
            onPetClick = onPetClick
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pets(
    onPetClick: (PetForAdoption) -> Unit
) {
    val petsForAdoption = remember { petsForAdoption }
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        content = {
            items(petsForAdoption) { petForAdoption ->
                PetItem(
                    petForAdoption = petForAdoption,
                    onPetClick = onPetClick
                )
            }
        })
}

@Composable
fun PetItem(
    petForAdoption: PetForAdoption,
    onPetClick: (PetForAdoption) -> Unit,
    modifier: Modifier = Modifier
) {
    val pet = petForAdoption.pet
    Card(
        elevation = 4.dp,
        modifier = modifier
            .size(
                width = 240.dp,
                height = 224.dp
            )
            .padding(horizontal = 12.dp, vertical = 8.dp)
            .clickable { onPetClick(petForAdoption) },
        shape = RoundedCornerShape(
            topStart = 26.dp,
            topEnd = 0.dp,
            bottomEnd = 12.dp,
            bottomStart = 12.dp
        ),
        backgroundColor = Color.White
    ) {
        Column {
            Box(
                modifier = modifier
                    .height(152.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray),
            ) {
                PetImage(
                    imageUrl = pet.images.first(),
                    contentDescription = pet.name
                )
            }
            Box(
                modifier = modifier
                    .offset(y = (-16).dp)
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clip(
                        shape = RoundedCornerShape(
                            topStart = 26.dp,
                            topEnd = 0.dp
                        )
                    )
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(horizontal = 8.dp)
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Row {
                        Icon(
                            imageVector = pet.gender.icon(),
                            tint = pet.gender.color(),
                            contentDescription = null
                        )
                        Text(
                            text = pet.name,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.padding(start = 4.dp),
                            color = Color.Black,
                        )
                    }

                    Row {
                        Icon(
                            imageVector = Icons.Filled.LocationOn,
                            contentDescription = null
                        )
                        Text(
                            text = petForAdoption.location,
                            style = MaterialTheme.typography.subtitle2,
                            fontWeight = FontWeight.Light,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(start = 4.dp),
                        )
                    }
                }

            }

        }

    }
}

fun Gender.icon() = when (this) {
    Gender.MALE -> Icons.Filled.Male
    Gender.FEMALE -> Icons.Filled.Female
}

fun Gender.color() = when (this) {
    Gender.MALE -> Color.Cyan
    Gender.FEMALE -> Color.Magenta
}

@Composable
fun PetImage(
    imageUrl: String,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp
) {
    Surface(
        color = Color.LightGray,
        elevation = elevation,
        modifier = modifier
    ) {
        CoilImage(
            data = imageUrl,
            contentDescription = contentDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Preview("Pet Preview")
@Composable
fun PetPreview() {
    MyTheme {
        val pet = petsForAdoption.first()
        PetItem(
            petForAdoption = pet,
            onPetClick = {}
        )
    }
}
