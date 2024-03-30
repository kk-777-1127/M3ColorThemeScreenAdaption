package io.kk__777.m3colorthemescreenadaption.test
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color
import dynamiccolor.DynamicScheme
import dynamiccolor.MaterialDynamicColors

/*
作るものをコメントしていく
clientにこのアノテーションを実装してもらう
file@StaticSeedColorTheme(name = "hoge",color = Color(Int, Long?), fullyQualifiedClientThemeFunName = "Fully Qualified fun Name for App Theme")
file@StaticUriSourceTheme(name = "hoge",uri = "uri",  fullyQualifiedClientThemeFunName =...)
file@DynamicSourceTheme(name = "",  fullyQualifiedClientThemeFunName =...)
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
ここはつくらんくてもよい
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
変換色々
colorはclientからもらう
val rgb = ColorUtils.argbFromRgb(color.red.toInt(), color.green.toInt(), color.blue.toInt())
val hct = Hct.fromInt(rgb)
SchemeTonalSpot(hct, false, 0.0)
↓の関数に突っ込んで darkとlight を両方作る
 */

fun createScheme(dynamicScheme: DynamicScheme): ColorScheme {
    val materialDynamicColors = MaterialDynamicColors()
    return ColorScheme(
        primary = Color(materialDynamicColors.primary().getArgb(dynamicScheme)),
        onPrimary = Color(materialDynamicColors.onPrimary().getArgb(dynamicScheme)),
        primaryContainer = Color(materialDynamicColors.primaryContainer().getArgb(dynamicScheme)),
        onPrimaryContainer = Color(materialDynamicColors.onPrimaryContainer().getArgb(dynamicScheme)),
        inversePrimary = Color(materialDynamicColors.inversePrimary().getArgb(dynamicScheme)),
        secondary = Color(materialDynamicColors.secondary().getArgb(dynamicScheme)),
        onSecondary = Color(materialDynamicColors.onSecondary().getArgb(dynamicScheme)),
        secondaryContainer = Color(materialDynamicColors.secondaryContainer().getArgb(dynamicScheme)),
        onSecondaryContainer = Color(materialDynamicColors.onSecondaryContainer().getArgb(dynamicScheme)),
        tertiary = Color(materialDynamicColors.tertiary().getArgb(dynamicScheme)),
        onTertiary = Color(materialDynamicColors.onTertiary().getArgb(dynamicScheme)),
        tertiaryContainer = Color(materialDynamicColors.tertiaryContainer().getArgb(dynamicScheme)),
        onTertiaryContainer = Color(materialDynamicColors.onTertiaryContainer().getArgb(dynamicScheme)),
        background = Color(materialDynamicColors.background().getArgb(dynamicScheme)),
        onBackground = Color(materialDynamicColors.onBackground().getArgb(dynamicScheme)),
        surface = Color(materialDynamicColors.surface().getArgb(dynamicScheme)),
        onSurface = Color(materialDynamicColors.onSurface().getArgb(dynamicScheme)),
        surfaceVariant = Color(materialDynamicColors.surfaceVariant().getArgb(dynamicScheme)),
        onSurfaceVariant = Color(materialDynamicColors.onSurfaceVariant().getArgb(dynamicScheme)),
        surfaceTint = Color(materialDynamicColors.surfaceTint().getArgb(dynamicScheme)),
        inverseSurface = Color(materialDynamicColors.inverseSurface().getArgb(dynamicScheme)),
        inverseOnSurface = Color(materialDynamicColors.inverseOnSurface().getArgb(dynamicScheme)),
        error = Color(materialDynamicColors.error().getArgb(dynamicScheme)),
        onError = Color(materialDynamicColors.onError().getArgb(dynamicScheme)),
        errorContainer = Color(materialDynamicColors.errorContainer().getArgb(dynamicScheme)),
        onErrorContainer = Color(materialDynamicColors.onErrorContainer().getArgb(dynamicScheme)),
        outline = Color(materialDynamicColors.outline().getArgb(dynamicScheme)),
        outlineVariant = Color(materialDynamicColors.outlineVariant().getArgb(dynamicScheme)),
        scrim = Color(materialDynamicColors.scrim().getArgb(dynamicScheme))
    )
}

/*
ここまでで、ライト ダークの colorSchemeはできているから

val BlueLightColors = lightColorScheme( <- これはベタでKMP作成
primary =  <- ここが必要

Color() <- はベタ
中身は 0xFF1B1B1F みたいな文字列が取れれば勝ち
colorScheme.primary.toArg() の Int　取得値をいれればよさそう
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