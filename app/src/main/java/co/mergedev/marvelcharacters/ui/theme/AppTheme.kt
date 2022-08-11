package co.mergedev.marvelcharacters.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable


@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkPaletteColors else LightPaletteColors

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}


val DarkPaletteColors = darkColors(
    primary = AppBrandColor.PrimaryColor,
    primaryVariant = AppBrandColor.PrimaryDarkColor,
    secondary = AppBrandColor.SecondaryColor,
    secondaryVariant = AppBrandColor.SecondaryDarkColor,
    background = AppSystemColor.BackgroundDarkColor,
    surface = AppBrandColor.SecondaryDarkColor,
    onSecondary = AppSystemColor.PrimaryTextColor,
    onBackground = AppSystemColor.PrimaryTextColor,
    onSurface = AppSystemColor.PrimaryTextColor,
)

val LightPaletteColors = lightColors(
    primary = AppBrandColor.PrimaryColor,
    primaryVariant = AppBrandColor.PrimaryDarkColor,
    secondary = AppBrandColor.SecondaryColor,
    secondaryVariant = AppBrandColor.SecondaryDarkColor,
    background = AppSystemColor.BackgroundLightColor,
    surface = AppBrandColor.SecondaryColor,
    onPrimary = AppSystemColor.PrimaryTextColor,
    onSecondary = AppSystemColor.PrimaryTextColor,
    onBackground = AppSystemColor.SecondaryTextColor,
    onSurface = AppSystemColor.PrimaryTextColor,
)
