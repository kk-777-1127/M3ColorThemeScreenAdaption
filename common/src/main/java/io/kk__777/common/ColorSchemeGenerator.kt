package io.kk__777.common

import dynamiccolor.DynamicScheme
import dynamiccolor.MaterialDynamicColors
import hct.Hct
import quantize.QuantizerCelebi
import scheme.SchemeTonalSpot
import score.Score
import java.awt.image.BufferedImage
import java.io.ByteArrayInputStream
import java.lang.IllegalStateException
import javax.imageio.ImageIO

data class RawColorScheme(
    val primary: Int,
    val onPrimary: Int,
    val primaryContainer: Int,
    val onPrimaryContainer: Int,
    val inversePrimary: Int,
    val secondary: Int,
    val onSecondary: Int,
    val secondaryContainer: Int,
    val onSecondaryContainer: Int,
    val tertiary: Int,
    val onTertiary: Int,
    val tertiaryContainer: Int,
    val onTertiaryContainer: Int,
    val background: Int,
    val onBackground: Int,
    val surface: Int,
    val onSurface: Int,
    val surfaceVariant: Int,
    val onSurfaceVariant: Int,
    val surfaceTint: Int,
    val inverseSurface: Int,
    val inverseOnSurface: Int,
    val error: Int,
    val onError: Int,
    val errorContainer: Int,
    val onErrorContainer: Int,
    val outline: Int,
    val outlineVariant: Int,
    val scrim: Int
)

typealias LightColorScheme = RawColorScheme
typealias DarkColorScheme = RawColorScheme
data class ColorSchemes(
    val lightColorScheme: LightColorScheme,
    val darkColorScheme: DarkColorScheme
)

interface ColorSchemeGenerator {
    fun generateColorSchemes(rgb: Long): ColorSchemes

    // TODO : Android Platform not support ImageIO..
//    fun generateColorSchemes(imageArray: ByteArray): ColorSchemes

    companion object {
        fun create(): ColorSchemeGenerator = ColorSchemeGeneratorImpl(BitmapCoordinatorForMCU())
    }
}

internal class ColorSchemeGeneratorImpl(
    private val bitmapCoordinator: BitmapCoordinatorForMCU
): ColorSchemeGenerator {
    override fun generateColorSchemes(rgb: Long): ColorSchemes {
        val hct = Hct.fromInt(rgb.toInt())
        return ColorSchemes(
            lightColorScheme = SchemeTonalSpot(hct, false, 0.0).createScheme(),
            darkColorScheme = SchemeTonalSpot(hct, true, 0.0).createScheme()
        )
    }

//    override fun generateColorSchemes(imageArray: ByteArray): ColorSchemes {
//        val pixels = bitmapCoordinator.getPixelsFromImage(imageArray)
//        val seedColor = Score.score(QuantizerCelebi.quantize(pixels, 128))
//            .firstOrNull() ?: throw IllegalStateException("Can not create seed color from image")
//        val hct = Hct.fromInt(seedColor)
//        return ColorSchemes(
//            lightColorScheme = SchemeTonalSpot(hct, false, 0.0).createScheme(),
//            darkColorScheme = SchemeTonalSpot(hct, true, 0.0).createScheme()
//        )
//    }

    private fun DynamicScheme.createScheme(): RawColorScheme {
        val materialDynamicColors = MaterialDynamicColors()
        return RawColorScheme(
            primary = materialDynamicColors.primary().getArgb(this),
            onPrimary = materialDynamicColors.onPrimary().getArgb(this),
            primaryContainer = materialDynamicColors.primaryContainer().getArgb(this),
            onPrimaryContainer = materialDynamicColors.onPrimaryContainer().getArgb(this),
            inversePrimary = materialDynamicColors.inversePrimary().getArgb(this),
            secondary = materialDynamicColors.secondary().getArgb(this),
            onSecondary = materialDynamicColors.onSecondary().getArgb(this),
            secondaryContainer = materialDynamicColors.secondaryContainer().getArgb(this),
            onSecondaryContainer = materialDynamicColors.onSecondaryContainer().getArgb(this),
            tertiary = materialDynamicColors.tertiary().getArgb(this),
            onTertiary = materialDynamicColors.onTertiary().getArgb(this),
            tertiaryContainer = materialDynamicColors.tertiaryContainer().getArgb(this),
            onTertiaryContainer = materialDynamicColors.onTertiaryContainer().getArgb(this),
            background = materialDynamicColors.background().getArgb(this),
            onBackground = materialDynamicColors.onBackground().getArgb(this),
            surface = materialDynamicColors.surface().getArgb(this),
            onSurface = materialDynamicColors.onSurface().getArgb(this),
            surfaceVariant = materialDynamicColors.surfaceVariant().getArgb(this),
            onSurfaceVariant = materialDynamicColors.onSurfaceVariant().getArgb(this),
            surfaceTint = materialDynamicColors.surfaceTint().getArgb(this),
            inverseSurface = materialDynamicColors.inverseSurface().getArgb(this),
            inverseOnSurface = materialDynamicColors.inverseOnSurface().getArgb(this),
            error = materialDynamicColors.error().getArgb(this),
            onError = materialDynamicColors.onError().getArgb(this),
            errorContainer = materialDynamicColors.errorContainer().getArgb(this),
            onErrorContainer = materialDynamicColors.onErrorContainer().getArgb(this),
            outline = materialDynamicColors.outline().getArgb(this),
            outlineVariant = materialDynamicColors.outlineVariant().getArgb(this),
            scrim = materialDynamicColors.scrim().getArgb(this)
        )
    }
}

internal class BitmapCoordinatorForMCU {

    fun getPixelsFromImage(imageArray: ByteArray): IntArray {
        ByteArrayInputStream(imageArray).use { inputStream ->
            val image: BufferedImage = ImageIO.read(inputStream)

            // 画像を128x128ピクセルにリサイズ
            val resizedImage = BufferedImage(128, 128, BufferedImage.TYPE_INT_ARGB)
            val graphics = resizedImage.createGraphics()
            graphics.drawImage(image, 0, 0, 128, 128, null)
            graphics.dispose()

            // リサイズされた画像からピクセル配列を取得
            return IntArray(128 * 128) { i ->
                val x = i % 128
                val y = i / 128
                resizedImage.getRGB(x, y)
            }
        }
    }
}