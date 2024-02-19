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
fun ChuckStart(
    chuckVM : ChuckViewModel,
    goSearch : () -> Unit,
    goCategories : () -> Unit
) {
    Column {
        Text("START", modifier = Modifier.background(Color.White))

        Button(onClick = { goSearch() }) {
            Text("SEARCH")
        }
        Button(onClick = { goCategories() }) {
            Text("CATEGORIES")
        }
    }
}

@Preview
@Composable
fun ChuckStartPreview() {
    ChuckStart(ChuckViewModel(), {},{})
}