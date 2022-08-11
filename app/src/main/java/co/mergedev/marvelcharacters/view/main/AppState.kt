package co.mergedev.marvelcharacters.view.main

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import co.mergedev.marvelcharacters.ui.navigation.routes.AppRoute


/**
 * Manage app UI elements logic and UI state logic.
 *
 * @param navController
 * @param scaffoldState
 * @param startDestination
 */
class AppState(
    val navController: NavHostController,
    val scaffoldState: ScaffoldState,
    val startDestination: AppRoute = AppRoute.Launch
) {

    // TODO: implement app ui state logic
}

/**
 * TODO: document
 *
 * @param navController
 * @param scaffoldState
 */
@Composable
fun rememberAppState(
    navController: NavHostController = rememberNavController(),
    scaffoldState: ScaffoldState = rememberScaffoldState()
) = remember(navController) {
    AppState(navController, scaffoldState)
}