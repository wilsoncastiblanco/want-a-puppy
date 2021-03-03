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

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.WantAPuppyTheme

@Composable
fun SearchBar() {
    Surface(
        contentColor = MaterialTheme.colors.primaryVariant,
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 24.dp, vertical = 8.dp)
    ) {
        var textFieldValue by mutableStateOf(TextFieldValue(""))
        Box(modifier = Modifier.fillMaxSize()) {
            if (textFieldValue.text.isEmpty()) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize()
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Search,
                        tint = MaterialTheme.colors.secondaryVariant,
                        contentDescription = stringResource(R.string.hint_search)
                    )
                    Text(text = stringResource(R.string.hint_search))
                }

            }
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentHeight(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = textFieldValue.text,
                    onValueChange = { textFieldValue = TextFieldValue(it) },
                    modifier = Modifier
                        .weight(1f)
                )

            }
        }

    }
}

@Preview("Search Preview")
@Composable
fun SearchPreview() {
    WantAPuppyTheme {
        SearchBar()
    }
}