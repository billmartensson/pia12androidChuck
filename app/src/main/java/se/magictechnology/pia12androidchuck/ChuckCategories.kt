package se.magictechnology.pia12androidchuck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ChuckCategories(chuckVM : ChuckViewModel,goCategory : () -> Unit) {
    Column {
        Text("CATEGORIES", modifier = Modifier.background(Color.White))

        Button(onClick = { goCategory() }) {
            Text("CATEGORY")
        }
    }
}

@Preview
@Composable
fun ChuckCategoriesPreview() {
    ChuckCategories(ChuckViewModel(), {})
}