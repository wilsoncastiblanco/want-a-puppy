/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Female
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Male
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
import com.example.androiddevchallenge.ui.theme.WantAPuppyTheme
import com.example.androiddevchallenge.ui.theme.cyan100
import com.example.androiddevchallenge.ui.theme.magenta100
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetsCollection(
    onPetClick: (PetForAdoption) -> Unit
) {
    Column {
        Text(
            text = stringResource(R.string.title_pets),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
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
        backgroundColor = MaterialTheme.colors.background
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
    Gender.MALE -> cyan100
    Gender.FEMALE -> magenta100
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
    WantAPuppyTheme {
        val pet = petsForAdoption.first()
        PetItem(
            petForAdoption = pet,
            onPetClick = {}
        )
    }
}
