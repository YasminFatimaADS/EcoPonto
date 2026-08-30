package br.com.fiap.ecoponto.ui.theme

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

private val EcoLightColorScheme = lightColorScheme(

    primary = EcoGreen,
    onPrimary = EcoWhite,
    secondary = EcoAccent,
    onSecondary = EcoWhite,
    tertiary = EcoSuccess,
    onTertiary = EcoWarning,
    background = EcoBackground,
    onBackground = EcoText,
    surface = EcoWhite,
    onSurface = EcoText,
    error = EcoError,
    onError = EcoWhite,
    surfaceVariant = EcoCard,
    onSurfaceVariant = EcoLogo,
    scrim = EcoTextSecondary
)

private val EcoDarkColorScheme = darkColorScheme(
    primary = EcoLight,
    onPrimary = EcoBackgroundDark,
    secondary = EcoAccent,
    onSecondary = EcoBackgroundDark,
    tertiary = EcoSuccess,
    onTertiary = EcoBackgroundDark,
    background = EcoBackgroundDark,
    onBackground = EcoTextDark,
    surface = EcoCardDark,
    onSurface = EcoTextDark,
    error = EcoError,
    onError = EcoWhite
)

@Composable
fun EcoPontoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> EcoDarkColorScheme
        else -> EcoLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}