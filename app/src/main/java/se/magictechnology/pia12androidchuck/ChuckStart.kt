package se.magictechnology.pia12androidchuck

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ChuckStart(
    chuckVM : ChuckViewModel,
    goSearch : () -> Unit,
    goCategories : () -> Unit
) {
    val currentjoke by chuckVM.currentjoke.collectAsState()

    Column {
        Text("START", modifier = Modifier.background(Color.White))

        if(currentjoke == null) {
            Text("Loading...")
        } else {
            Text(currentjoke!!.value)
        }

        Button(onClick = {
            chuckVM.randomjoke()
        }) {
            Text("Random joke")
        }


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