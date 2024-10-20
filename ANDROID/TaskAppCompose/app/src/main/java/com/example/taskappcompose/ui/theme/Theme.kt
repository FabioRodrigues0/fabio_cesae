package com.example.taskappcompose.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.taskappcompose.ui.theme.Background
import com.example.taskappcompose.ui.theme.Pink80
import com.example.taskappcompose.ui.theme.Purple40
import com.example.taskappcompose.ui.theme.Purple80
import com.example.taskappcompose.ui.theme.PurpleGrey40
import com.example.taskappcompose.ui.theme.PurpleGrey80

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Background,
    onBackground = Background,
    onPrimary = Primary,
    primaryContainer = Primary
)

private val LightColorScheme = lightColorScheme(
    // Background
    background = Background,
    onBackground = Background,

    // Primary
    primary = Primary,
    onPrimary = Primary,
    primaryContainer = Primary,

    // Secondary
    secondary = Secondary,
    onSecondary = Secondary,

    // Surface
    surface = PurpleGrey80,
    onSurface = PurpleGrey80,

    // Tertiary
    tertiary = Pink40,
    onTertiary = Pink40,
)

@Composable
fun TaskAppComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}