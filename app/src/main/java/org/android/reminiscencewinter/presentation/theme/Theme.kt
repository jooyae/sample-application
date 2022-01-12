package org.android.reminiscencewinter

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColorPalette = lightColors(
    primary = Black,
    primaryVariant = White,
    secondary = Grey
)

private val DarkColorPalette = darkColors(
    primary = Black,
    primaryVariant = Grey,
    secondary = White
)

@Composable
fun ComposeStudyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shape,
        content = content
    )
}

