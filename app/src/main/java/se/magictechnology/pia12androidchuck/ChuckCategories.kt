package se.magictechnology.pia12androidchuck

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ChuckCategories(chuckVM : ChuckViewModel,goCategory : (catname : String) -> Unit) {
    val categories by chuckVM.categories.collectAsState()
    Column {
        Text("CATEGORIES", modifier = Modifier.background(Color.White))

        Button(onClick = { goCategory("") }) {
            Text("CATEGORY")
        }

        Button(onClick = { chuckVM.loadcategories() }) {
            Text("LOAD")
        }

        if(categories != null) {
            LazyColumn {
                items(categories!!) {catname ->
                    Text(catname, modifier = Modifier.clickable {
                        goCategory(catname)
                    })
                }
            }
        } else {
            Text("Loading...")
        }
    }
}

@Preview
@Composable
fun ChuckCategoriesPreview() {
    ChuckCategories(ChuckViewModel(), {})
}