package com.example.androiddevchallenge.ui.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.model.PetCategory
import com.example.androiddevchallenge.repository.petCategories
import com.example.androiddevchallenge.ui.theme.WantAPuppyTheme

@Composable
fun CategoriesList(
    onCategoryClick: (Long) -> Unit,
) {
    Column(content = {
        Text(
            text = stringResource(id = R.string.title_categories),
            style = MaterialTheme.typography.h6,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Categories(
            onCategoryClick = onCategoryClick,
        )
    })
}

@Composable
fun Categories(
    onCategoryClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    val categories = remember { petCategories }
    LazyRow(modifier) {
        items(categories) { petCategory ->
            CategoryItem(category = petCategory, onCategoryClick = onCategoryClick)
        }
    }
}

@Composable
fun CategoryItem(
    category: PetCategory,
    onCategoryClick: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier.padding(
            start = 4.dp,
            end = 4.dp,
            bottom = 8.dp
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .clickable(onClick = { onCategoryClick(category.id) })
                .padding(8.dp)
        ) {
            CategoryImage(
                categoryIcon = category.icon,
                elevation = 4.dp,
                contentDescription = category.name,
                modifier = Modifier.size(60.dp)
            )
        }
    }
}

@Composable
fun CategoryImage(
    categoryIcon: Int,
    modifier: Modifier = Modifier,
    elevation: Dp = 0.dp,
    contentDescription: String? = null
) {
    Surface(
        elevation = elevation,
        shape = CircleShape,
        modifier = modifier
    ) {
        Icon(
            imageVector = ImageVector.vectorResource(id = categoryIcon),
            contentDescription = contentDescription,
            tint = Color.Unspecified,
            modifier = Modifier.padding(12.dp)
        )
    }
}


@Preview("Category Preview")
@Composable
fun CategoryPreview() {
    WantAPuppyTheme {
        val petCategory = petCategories.first()
        CategoryItem(
            category = petCategory,
            onCategoryClick = {}
        )
    }
}
