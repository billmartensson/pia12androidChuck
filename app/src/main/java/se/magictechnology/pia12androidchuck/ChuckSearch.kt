package se.magictechnology.pia12androidchuck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ChuckSearch(chuckVM : ChuckViewModel) {
    Column {
        Text("SEARCH", modifier = Modifier.background(Color.White))
    }
}

@Preview
@Composable
fun ChuckSearchPreview() {
    ChuckSearch(ChuckViewModel())
}