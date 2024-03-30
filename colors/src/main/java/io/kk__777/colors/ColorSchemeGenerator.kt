package io.kk__777.colors

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import dynamiccolor.DynamicScheme
import dynamiccolor.MaterialDynamicColors
import hct.Hct
import scheme.SchemeTonalSpot
import utils.ColorUtils

typealias LightColorScheme = ColorScheme
typealias DarkColorScheme = ColorScheme
data class ColorSchemes(
    val lightColorScheme: LightColorScheme,
    val darkColorScheme: DarkColorScheme
)

interface ColorSchemeGenerator {
    fun generateColorSchemes(color: Color): ColorSchemes

    companion object {
        // TODO DI Framework
        fun create():ColorSchemeGenerator = ColorSchemeGeneratorImpl()
    }
}

internal class ColorSchemeGeneratorImpl: ColorSchemeGenerator {
    override fun generateColorSchemes(color: Color): ColorSchemes {
        val rgb = ColorUtils.argbFromRgb(color.red.toInt(), color.green.toInt(), color.blue.toInt())
        val hct = Hct.fromInt(rgb)
        return ColorSchemes(
            lightColorScheme = SchemeTonalSpot(hct, false, 0.0).createScheme(),
            darkColorScheme = SchemeTonalSpot(hct, true, 0.0).createScheme()
        )
    }

    private fun DynamicScheme.createScheme(): ColorScheme {
        val materialDynamicColors = MaterialDynamicColors()
        return ColorScheme(
            primary = Color(materialDynamicColors.primary().getArgb(this)),
            onPrimary = Color(materialDynamicColors.onPrimary().getArgb(this)),
            primaryContainer = Color(materialDynamicColors.primaryContainer().getArgb(this)),
            onPrimaryContainer = Color(materialDynamicColors.onPrimaryContainer().getArgb(this)),
            inversePrimary = Color(materialDynamicColors.inversePrimary().getArgb(this)),
            secondary = Color(materialDynamicColors.secondary().getArgb(this)),
            onSecondary = Color(materialDynamicColors.onSecondary().getArgb(this)),
            secondaryContainer = Color(materialDynamicColors.secondaryContainer().getArgb(this)),
            onSecondaryContainer = Color(materialDynamicColors.onSecondaryContainer().getArgb(this)),
            tertiary = Color(materialDynamicColors.tertiary().getArgb(this)),
            onTertiary = Color(materialDynamicColors.onTertiary().getArgb(this)),
            tertiaryContainer = Color(materialDynamicColors.tertiaryContainer().getArgb(this)),
            onTertiaryContainer = Color(materialDynamicColors.onTertiaryContainer().getArgb(this)),
            background = Color(materialDynamicColors.background().getArgb(this)),
            onBackground = Color(materialDynamicColors.onBackground().getArgb(this)),
            surface = Color(materialDynamicColors.surface().getArgb(this)),
            onSurface = Color(materialDynamicColors.onSurface().getArgb(this)),
            surfaceVariant = Color(materialDynamicColors.surfaceVariant().getArgb(this)),
            onSurfaceVariant = Color(materialDynamicColors.onSurfaceVariant().getArgb(this)),
            surfaceTint = Color(materialDynamicColors.surfaceTint().getArgb(this)),
            inverseSurface = Color(materialDynamicColors.inverseSurface().getArgb(this)),
            inverseOnSurface = Color(materialDynamicColors.inverseOnSurface().getArgb(this)),
            error = Color(materialDynamicColors.error().getArgb(this)),
            onError = Color(materialDynamicColors.onError().getArgb(this)),
            errorContainer = Color(materialDynamicColors.errorContainer().getArgb(this)),
            onErrorContainer = Color(materialDynamicColors.onErrorContainer().getArgb(this)),
            outline = Color(materialDynamicColors.outline().getArgb(this)),
            outlineVariant = Color(materialDynamicColors.outlineVariant().getArgb(this)),
            scrim = Color(materialDynamicColors.scrim().getArgb(this))
        )
    }

}