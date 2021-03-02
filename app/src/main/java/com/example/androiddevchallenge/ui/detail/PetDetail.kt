package com.example.androiddevchallenge.ui.detail

import android.graphics.Paint
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.PetForAdoption
import dev.chrisbanes.accompanist.insets.statusBarsPadding

private val MinTitleOffset = 56.dp

@Composable
fun PetDetail(
    petForAdoption: PetForAdoption,
    upPress: () -> Unit
) {
    val pet = petForAdoption.pet
    Surface(color = Color.Cyan) {
        Column(Modifier.fillMaxSize()) {
            val scroll = rememberScrollState(0)
            Up(upPress)
            Header(scroll.value, pet.name)
            Body(scroll, petForAdoption = petForAdoption)
        }
    }

}

@Composable
fun Body(scroll: ScrollState, petForAdoption: PetForAdoption) {
    Column {
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .statusBarsPadding()
                .height(MinTitleOffset)
        )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .verticalScroll(scroll)
                .clip(
                    shape = RoundedCornerShape(
                        topStart = 26.dp,
                        topEnd = 26.dp,
                        bottomEnd = 0.dp,
                        bottomStart = 0.dp
                    )
                )
                .background(Color.White)
        ) {
            Surface(Modifier.fillMaxWidth()) {
                Column {
                    Text(text = petForAdoption.description)
                    Spacer(Modifier.height(16.dp))

                    Card(elevation = 4.dp) {
                        Row {
                            Column {
                                Text(text = "Age")
                                Text(text = "${petForAdoption.pet.age} years")
                            }
                            Column {
                                Text(text = "Size")
                                Text(text = petForAdoption.pet.size.name)
                            }
                        }
                    }

                    Button(onClick = { /*TODO*/ }, Modifier.fillMaxWidth()) {
                        Text(text = "Adopt Me")
                    }
                }
            }


        }

    }
}

@Composable
fun Header(scroll: Int, petName: String) {
    Box(
        modifier = Modifier
            .height(240.dp)
            .fillMaxWidth()
    ) {
        Column {
            Text(
                text = petName,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(start = 4.dp),
                color = Color.White,
            )
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
            tint = Color.White,
            contentDescription = "Back"
        )
    }
}
