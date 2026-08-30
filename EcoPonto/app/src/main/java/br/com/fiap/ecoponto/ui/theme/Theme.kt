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

    // Cor principal
    // Usada em botões principais, elementos selecionados e destaques
    primary = EcoGreen,
    onPrimary = EcoWhite,

    // Cor secundária
    // Usada em elementos de apoio, como mapa e localização
    secondary = EcoAccent,
    onSecondary = EcoText,

    // Cor terciária
    // Usada em confirmações e destaques alternativos
    tertiary = EcoSuccess,
    onTertiary = EcoWhite,

    // Fundo geral das telas
    background = EcoBackground,
    onBackground = EcoText,

    // Cards, caixas, menus e campos
    surface = EcoCard,
    onSurface = EcoText,

    // Variação de superfície
    // Pode ser usada em cards secundários e campos desabilitados
    surfaceVariant = EcoLight,
    onSurfaceVariant = EcoTextSecondary,

    // Bordas de campos e componentes
    outline = EcoCardBorder,

    // Erros
    error = EcoError,
    onError = EcoWhite,

)

private val EcoDarkColorScheme = darkColorScheme(

    // Cor principal
    primary = EcoLight,
    onPrimary = EcoBackgroundDark,

    // Cor secundária
    secondary = EcoAccent,
    onSecondary = EcoBackgroundDark,

    // Cor terciária
    tertiary = EcoSuccess,
    onTertiary = EcoBackgroundDark,

    // Fundo geral das telas
    background = EcoBackgroundDark,
    onBackground = EcoTextDark,

    // Cards, caixas, menus e campos
    surface = EcoCardDark,
    onSurface = EcoTextDark,

    // Variação de superfície
    surfaceVariant = EcoGreenDark,
    onSurfaceVariant = EcoTextDark,

    // Bordas
    outline = EcoCardBorder,

    // Erros
    error = EcoError,
    onError = EcoWhite,

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