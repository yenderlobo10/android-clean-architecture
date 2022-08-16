package co.mergedev.marvelcharacters.view.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import co.mergedev.marvelcharacters.ui.navigation.AppNavigationHost
import co.mergedev.marvelcharacters.ui.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint

/**
 * App wrap activity.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MarvelCharactersApp()
        }
    }
}

/**
 * App root content wrapper.
 */
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MarvelCharactersApp() {

    val appState = rememberAppState()

    AppTheme {
        Scaffold(
            scaffoldState = appState.scaffoldState
        ) {
            AppNavigationHost(
                appState = appState
            )
        }
    }
}