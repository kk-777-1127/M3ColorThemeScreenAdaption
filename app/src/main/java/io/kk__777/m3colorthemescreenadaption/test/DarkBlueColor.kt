package io.kk__777.m3colorthemescreenadaption.test
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

/*
作るものをコメントしていく
clientにこのアノテーションを実装してもらう
file@StaticColorSourceTheme(name = "hoge",color = "rgb?hex?", fullyQualifiedTheneName = "Fully Qualified fun Name for App Theme")
file@StaticUriSourceTheme(name = "hoge",uri = "uri",  fullyQualifiedTheneName =...)
file@StaticFileSourceTheme(name = "hoge", path = "path", fullyQualifiedTheneName =...)

file@DynamicSourceTheme(name = "",  fullyQualifiedTheneName =...)
↓
colorSheme生成
HogeTheme生成
↓
HogeTheme {}
 */

/*
まず、これがClientに指定されるのでKSPで見つける
 */
val blueSeed = Color(0xFF00008B)

/*
https://github.com/material-foundation/material-color-utilities/blob/main/make_schemes.md
gradleで公開されているわけではないが jarかなんかでこれを入れて 下の色を全部作る
 */
val md_theme_light_blue_primary = Color(0xFF4951C3)
val md_theme_light_blue_onPrimary = Color(0xFFFFFFFF)
val md_theme_light_blue_primaryContainer = Color(0xFFE0E0FF)
val md_theme_light_blue_onPrimaryContainer = Color(0xFF00006E)
val md_theme_light_blue_secondary = Color(0xFF5C5D72)
val md_theme_light_blue_onSecondary = Color(0xFFFFFFFF)
val md_theme_light_blue_secondaryContainer = Color(0xFFE1E0F9)
val md_theme_light_blue_onSecondaryContainer = Color(0xFF191A2C)
val md_theme_light_blue_tertiary = Color(0xFF78536B)
val md_theme_light_blue_onTertiary = Color(0xFFFFFFFF)
val md_theme_light_blue_tertiaryContainer = Color(0xFFFFD8EE)
val md_theme_light_blue_onTertiaryContainer = Color(0xFF2E1126)
val md_theme_light_blue_error = Color(0xFFBA1A1A)
val md_theme_light_blue_errorContainer = Color(0xFFFFDAD6)
val md_theme_light_blue_onError = Color(0xFFFFFFFF)
val md_theme_light_blue_onErrorContainer = Color(0xFF410002)
val md_theme_light_blue_background = Color(0xFFFFFBFF)
val md_theme_light_blue_onBackground = Color(0xFF1B1B1F)
val md_theme_light_blue_surface = Color(0xFFFFFBFF)
val md_theme_light_blue_onSurface = Color(0xFF1B1B1F)
val md_theme_light_blue_surfaceVariant = Color(0xFFE4E1EC)
val md_theme_light_blue_onSurfaceVariant = Color(0xFF46464F)
val md_theme_light_blue_outline = Color(0xFF777680)
val md_theme_light_blue_inverseOnSurface = Color(0xFFF3EFF4)
val md_theme_light_blue_inverseSurface = Color(0xFF303034)
val md_theme_light_blue_inversePrimary = Color(0xFFBFC2FF)
val md_theme_light_blue_shadow = Color(0xFF000000)
val md_theme_light_blue_surfaceTint = Color(0xFF4951C3)
val md_theme_light_blue_outlineVariant = Color(0xFFC7C5D0)
val md_theme_light_blue_scrim = Color(0xFF000000)

val md_theme_dark_blue_primary = Color(0xFFBFC2FF)
val md_theme_dark_blue_onPrimary = Color(0xFF141994)
val md_theme_dark_blue_primaryContainer = Color(0xFF3037AA)
val md_theme_dark_blue_onPrimaryContainer = Color(0xFFE0E0FF)
val md_theme_dark_blue_secondary = Color(0xFFC5C4DD)
val md_theme_dark_blue_onSecondary = Color(0xFF2E2F42)
val md_theme_dark_blue_secondaryContainer = Color(0xFF444559)
val md_theme_dark_blue_onSecondaryContainer = Color(0xFFE1E0F9)
val md_theme_dark_blue_tertiary = Color(0xFFE8B9D5)
val md_theme_dark_blue_onTertiary = Color(0xFF46263B)
val md_theme_dark_blue_tertiaryContainer = Color(0xFF5E3C52)
val md_theme_dark_blue_onTertiaryContainer = Color(0xFFFFD8EE)
val md_theme_dark_blue_error = Color(0xFFFFB4AB)
val md_theme_dark_blue_errorContainer = Color(0xFF93000A)
val md_theme_dark_blue_onError = Color(0xFF690005)
val md_theme_dark_blue_onErrorContainer = Color(0xFFFFDAD6)
val md_theme_dark_blue_background = Color(0xFF1B1B1F)
val md_theme_dark_blue_onBackground = Color(0xFFE5E1E6)
val md_theme_dark_blue_surface = Color(0xFF1B1B1F)
val md_theme_dark_blue_onSurface = Color(0xFFE5E1E6)
val md_theme_dark_blue_surfaceVariant = Color(0xFF46464F)
val md_theme_dark_blue_onSurfaceVariant = Color(0xFFC7C5D0)
val md_theme_dark_blue_outline = Color(0xFF918F9A)
val md_theme_dark_blue_inverseOnSurface = Color(0xFF1B1B1F)
val md_theme_dark_blue_inverseSurface = Color(0xFFE5E1E6)
val md_theme_dark_blue_inversePrimary = Color(0xFF4951C3)
val md_theme_dark_blue_shadow = Color(0xFF000000)
val md_theme_dark_blue_surfaceTint = Color(0xFFBFC2FF)
val md_theme_dark_blue_outlineVariant = Color(0xFF46464F)
val md_theme_dark_blue_scrim = Color(0xFF000000)


/*
次にこれを作る KSP で行ける
 */
val BlueLightColors = lightColorScheme(
    primary = md_theme_light_blue_primary,
    onPrimary = md_theme_light_blue_onPrimary,
    primaryContainer = md_theme_light_blue_primaryContainer,
    onPrimaryContainer = md_theme_light_blue_onPrimaryContainer,
    secondary = md_theme_light_blue_secondary,
    onSecondary = md_theme_light_blue_onSecondary,
    secondaryContainer = md_theme_light_blue_secondaryContainer,
    onSecondaryContainer = md_theme_light_blue_onSecondaryContainer,
    tertiary = md_theme_light_blue_tertiary,
    onTertiary = md_theme_light_blue_onTertiary,
    tertiaryContainer = md_theme_light_blue_tertiaryContainer,
    onTertiaryContainer = md_theme_light_blue_onTertiaryContainer,
    error = md_theme_light_blue_error,
    errorContainer = md_theme_light_blue_errorContainer,
    onError = md_theme_light_blue_onError,
    onErrorContainer = md_theme_light_blue_onErrorContainer,
    background = md_theme_light_blue_background,
    onBackground = md_theme_light_blue_onBackground,
    surface = md_theme_light_blue_surface,
    onSurface = md_theme_light_blue_onSurface,
    surfaceVariant = md_theme_light_blue_surfaceVariant,
    onSurfaceVariant = md_theme_light_blue_onSurfaceVariant,
    outline = md_theme_light_blue_outline,
    inverseOnSurface = md_theme_light_blue_inverseOnSurface,
    inverseSurface = md_theme_light_blue_inverseSurface,
    inversePrimary = md_theme_light_blue_inversePrimary,
    surfaceTint = md_theme_light_blue_surfaceTint,
    outlineVariant = md_theme_light_blue_outlineVariant,
    scrim = md_theme_light_blue_scrim,
)


val BlueDarkColors = darkColorScheme(
    primary = md_theme_dark_blue_primary,
    onPrimary = md_theme_dark_blue_onPrimary,
    primaryContainer = md_theme_dark_blue_primaryContainer,
    onPrimaryContainer = md_theme_dark_blue_onPrimaryContainer,
    secondary = md_theme_dark_blue_secondary,
    onSecondary = md_theme_dark_blue_onSecondary,
    secondaryContainer = md_theme_dark_blue_secondaryContainer,
    onSecondaryContainer = md_theme_dark_blue_onSecondaryContainer,
    tertiary = md_theme_dark_blue_tertiary,
    onTertiary = md_theme_dark_blue_onTertiary,
    tertiaryContainer = md_theme_dark_blue_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_blue_onTertiaryContainer,
    error = md_theme_dark_blue_error,
    errorContainer = md_theme_dark_blue_errorContainer,
    onError = md_theme_dark_blue_onError,
    onErrorContainer = md_theme_dark_blue_onErrorContainer,
    background = md_theme_dark_blue_background,
    onBackground = md_theme_dark_blue_onBackground,
    surface = md_theme_dark_blue_surface,
    onSurface = md_theme_dark_blue_onSurface,
    surfaceVariant = md_theme_dark_blue_surfaceVariant,
    onSurfaceVariant = md_theme_dark_blue_onSurfaceVariant,
    outline = md_theme_dark_blue_outline,
    inverseOnSurface = md_theme_dark_blue_inverseOnSurface,
    inverseSurface = md_theme_dark_blue_inverseSurface,
    inversePrimary = md_theme_dark_blue_inversePrimary,
    surfaceTint = md_theme_dark_blue_surfaceTint,
    outlineVariant = md_theme_dark_blue_outlineVariant,
    scrim = md_theme_dark_blue_scrim,
)

/*
io.kk__777.m3colorthemescreenadaption.ui.theme.M3ColorThemeScreenAdaptionTheme
 */