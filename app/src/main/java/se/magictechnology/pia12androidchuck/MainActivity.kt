package se.magictechnology.pia12androidchuck

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import se.magictechnology.pia12androidchuck.ui.theme.Pia12androidChuckTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pia12androidChuckTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ChuckNav()
                }
            }
        }
    }
}

enum class ChuckScreen() {
    Start,
    Categories,
    Category,
    Search
}

@Composable
fun ChuckNav(
    navController : NavHostController = rememberNavController(),
    chuckVM : ChuckViewModel = viewModel()
) {

    NavHost(navController = navController, startDestination = ChuckScreen.Start.name) {
        composable(ChuckScreen.Start.name) {
            ChuckStart(chuckVM,
                goSearch = { navController.navigate(ChuckScreen.Search.name) },
                goCategories = { navController.navigate(ChuckScreen.Categories.name) }
            )
        }
        composable(ChuckScreen.Categories.name) {
            ChuckCategories(chuckVM,
                goCategory = { navController.navigate(ChuckScreen.Category.name) }
            )
        }
        composable(ChuckScreen.Category.name) {
            ChuckCategory(chuckVM)
        }
        composable(ChuckScreen.Search.name) {
            ChuckSearch(chuckVM)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ChuckPreview() {
    Pia12androidChuckTheme {
        ChuckNav()
    }
}