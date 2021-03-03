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
package com.example.androiddevchallenge.ui.detail

import androidx.annotation.PluralsRes
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.Pet
import com.example.androiddevchallenge.model.PetForAdoption
import com.example.androiddevchallenge.ui.home.color
import com.example.androiddevchallenge.ui.home.icon
import dev.chrisbanes.accompanist.coil.CoilImage
import dev.chrisbanes.accompanist.insets.statusBarsPadding

private val ImageOverlap = 200.dp
private val MinTitleOffset = 56.dp
private val MaxTitleOffset = ImageOverlap + MinTitleOffset

@Composable
fun PetDetail(
    petForAdoption: PetForAdoption,
    upPress: () -> Unit
) {
    val pet = petForAdoption.pet
    Surface(color = petForAdoption.pet.gender.color().copy(alpha = 0.6f)) {
        val scroll = rememberScrollState(0)
        Column(Modifier.fillMaxSize()) {
            Up(upPress)
            Header(scroll.value, pet)
            Body(scroll, petForAdoption = petForAdoption)
        }
    }
}

@Composable
fun Body(scrollState: ScrollState, petForAdoption: PetForAdoption) {
    Surface(
        Modifier
            .fillMaxHeight()
            .clip(
                shape = RoundedCornerShape(
                    topStart = 26.dp,
                    topEnd = 26.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp
                )
            )
            .background(Color.White),
        elevation = 14.dp
    ) {
        Column(
            Modifier
                .padding(24.dp)
                .verticalScroll(scrollState),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = petForAdoption.description,
                fontWeight = FontWeight.Light,
                color = MaterialTheme.colors.secondary,
                modifier = Modifier.padding(start = 4.dp),
            )
            Spacer(Modifier.height(8.dp))
            PuppyAdditionalDetail(petForAdoption)
            Spacer(Modifier.height(8.dp))
            AdoptMeButton(petForAdoption)
        }
    }
}

@Composable
private fun AdoptMeButton(petForAdoption: PetForAdoption) {
    Button(
        onClick = {
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 24.dp),
        shape = RoundedCornerShape(16.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = petForAdoption.pet.gender.color()
        )
    ) {
        Text(
            text = stringResource(R.string.button_want_this_puppy),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.surface
        )
    }
}

@Composable
private fun PuppyAdditionalDetail(petForAdoption: PetForAdoption) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .height(120.dp)
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.detail_puppy_gender),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Icon(
                    imageVector = petForAdoption.pet.gender.icon(),
                    tint = petForAdoption.pet.gender.color(),
                    contentDescription = null
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(70.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = null
                )
                Text(
                    text = petForAdoption.location,
                    style = MaterialTheme.typography.subtitle2,
                    fontWeight = FontWeight.Light,
                    overflow = TextOverflow.Ellipsis,
                    maxLines = 1,
                    modifier = Modifier.padding(start = 4.dp),
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.detail_puppy_age),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = quantityStringResource(
                        R.plurals.detail_puppy_age_plural,
                        petForAdoption.pet.age,
                        petForAdoption.pet.age
                    ),
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )
            }
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
            )
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.detail_puppy_size),
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = petForAdoption.pet.size.name,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

@Composable
fun quantityStringResource(@PluralsRes id: Int, quantity: Int, vararg formatArgs: Any): String {
    return LocalContext.current.resources.getQuantityString(id, quantity, *formatArgs)
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Header(scrollValue: Int, pet: Pet) {
    val size by mutableStateOf(200.dp)
    val maxOffset = with(LocalDensity.current) { MaxTitleOffset.toPx() }
    val minOffset = with(LocalDensity.current) { MinTitleOffset.toPx() }
    val offset = (maxOffset - scrollValue).coerceAtLeast(minOffset)

    val offsetDp = with(LocalDensity.current) { offset.toDp() }

    BoxWithConstraints(
        modifier = Modifier
            .height(offsetDp)
            .fillMaxWidth()
    ) {

        Column {
            Text(
                text = pet.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(start = 4.dp),
                color = MaterialTheme.colors.surface,
                fontWeight = FontWeight.Bold,
            )

            val halfScreenSize = this@BoxWithConstraints.maxWidth.value / 2
            val rowState = rememberLazyListState(
                initialFirstVisibleItemIndex = pet.images.size / 2,
                initialFirstVisibleItemScrollOffset = -(halfScreenSize).toInt()
            )

            LazyRow(state = rowState) {
                items(pet.images) { imageUrl ->
                    Surface(
                        shape = CircleShape,
                        modifier = Modifier.padding(horizontal = 16.dp),
                        elevation = 8.dp,
                    ) {
                        CoilImage(
                            data = imageUrl,
                            contentDescription = pet.name,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.size(size)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun Up(upPress: () -> Unit) {
    IconButton(
        onClick = upPress,
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 16.dp, vertical = 10.dp)
            .size(36.dp)
            .background(
                color = Color.Transparent,
                shape = CircleShape
            )
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            tint = MaterialTheme.colors.surface,
            contentDescription = "Back"
        )
    }
}
