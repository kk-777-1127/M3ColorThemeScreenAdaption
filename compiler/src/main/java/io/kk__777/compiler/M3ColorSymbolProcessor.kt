package io.kk__777.compiler

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.BOOLEAN
import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.FunSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.LambdaTypeName
import com.squareup.kotlinpoet.MemberName
import com.squareup.kotlinpoet.ParameterSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.UNIT
import com.squareup.kotlinpoet.asClassName
import com.squareup.kotlinpoet.ksp.writeTo
import io.kk__777.common.ColorSchemeGenerator
import io.kk__777.common.RawColorScheme

private val Material3PackageName = "androidx.compose.material3"
private val MaterialThemeClassName = ClassName(Material3PackageName, "MaterialTheme")
private val ColorScheme = ClassName.bestGuess("androidx.compose.material3.ColorScheme")
private val Color = ClassName.bestGuess("androidx.compose.ui.graphics.Color")
private val Composable = ClassName.bestGuess("androidx.compose.runtime.Composable")
private val isDarkThemeFunction = MemberName("androidx.compose.foundation", "isSystemInDarkTheme")
private val toArgb = MemberName("androidx.compose.ui.graphics", "toArgb")
private val localViewCurrent = MemberName("androidx.compose.ui.platform", "LocalView")
private val sideEffect = MemberName("androidx.compose.runtime", "SideEffect")
private val getInsetsController = MemberName("androidx.core.view.WindowCompat", "getInsetsController")

class M3ColorSymbolProcessor(
    private val logger: KSPLogger,
    private val codeGenerator: CodeGenerator,
): SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        resolver.getSymbolsWithAnnotation("io.kk__777.library.StaticColorSourceTheme")
            .filterIsInstance<KSFunctionDeclaration>()
            .forEach { function ->
                val functionName = function.simpleName.asString()
                val annotation = function.annotations.first {
                    it.shortName.asString() == "StaticColorSourceTheme" &&
                            it.annotationType.resolve().declaration.qualifiedName?.asString() == "io.kk__777.library.StaticColorSourceTheme"
                }
                val color = annotation.arguments.find { it.name?.asString() == "rgbColor" }?.value as Long
                val name = annotation.arguments.find { it.name?.asString() == "name" }?.value as String
                val fileName = name.ifEmpty { "${functionName}_ColorTheme_Class" }
                val packageName = function.containingFile?.packageName?.asString() ?: "defaultPackage"

                val fileSpecBuilder = FileSpec.builder(packageName, fileName)
                    .addType(
                        TypeSpec.objectBuilder(fileName)
                            .addProperty(
                                PropertySpec.builder("color", Long::class, KModifier.CONST)
                                    .initializer("%L", color)
                                    .build()
                            )
                            .addProperty(
                                PropertySpec.builder("name", String::class, KModifier.CONST)
                                    .initializer("%S", name)
                                    .build()
                            )

                            .build()
                    )
                    .addFunction(
                        generateM3ColorThemeFunction(functionName = "${name}M3ColorTheme", color)
                    )
                    .build()
                fileSpecBuilder.writeTo(codeGenerator, Dependencies(false))
            }
        return emptyList()
    }

    private fun generateM3ColorThemeFunction(functionName: String, color: Long): FunSpec {
        val scheme = ColorSchemeGenerator.create().generateColorSchemes(color)
        val colorSchemeDark = createSchemeMap(scheme.darkColorScheme)
        val colorSchemeLight = createSchemeMap(scheme.lightColorScheme)
        return FunSpec.builder(functionName)
            .addAnnotation(Composable)

            .addParameter(
                ParameterSpec.builder("darkTheme", BOOLEAN)
                    .defaultValue("%M()", isDarkThemeFunction)
                    .build()
            )
            .addParameter(
                "content",
                LambdaTypeName.get(
                    receiver = null, parameters = arrayListOf(), returnType = UNIT
                ).copy(annotations = listOf(AnnotationSpec.builder(Composable).build())))

            .beginControlFlow("val colorScheme = if (darkTheme)")
            .addStatement("    %T(", ColorScheme)
            .also { builder ->
                colorSchemeDark.forEach { (name, value) ->
                    builder.addStatement("        $name = %T($value),", Color)
                }
            }
            .addStatement("    )")
            .nextControlFlow("else")
            .addStatement("    %T(", ColorScheme)
            .also { builder ->
                colorSchemeLight.forEach { (name, value) ->
                    builder.addStatement("        $name = %T($value),", Color)
                }
            }
            .addStatement("    )")
            .endControlFlow()

            .addCode(
                """
                    val view = %M.current
                    if (!view.isInEditMode) {
                        %M {
                            val window = (view.context as %T).window
                            window.statusBarColor = colorScheme.primary.%M()
                            %M(window, view).isAppearanceLightStatusBars = darkTheme
                        }
                    }
                    
                """.trimIndent(),
                localViewCurrent,
                sideEffect,
                ClassName("android.app", "Activity"),
                toArgb,
                getInsetsController
            )

            .addCode(
                """
                    val typography = %T.typography
                    MaterialTheme(
                        colorScheme = colorScheme,
                        typography = typography,
                        content = content
                    )
                """.trimIndent(),
                MaterialThemeClassName
            )
            .build()
    }

    private fun createSchemeMap(scheme: RawColorScheme): Map<String, Int> = mapOf(
        "primary" to scheme.primary,
        "onPrimary" to scheme.onPrimary,
        "primaryContainer" to scheme.primaryContainer,
        "onPrimaryContainer" to scheme.onPrimaryContainer,
        "inversePrimary" to scheme.inversePrimary,
        "secondary" to scheme.secondary,
        "onSecondary" to scheme.onSecondary,
        "secondaryContainer" to scheme.secondaryContainer,
        "onSecondaryContainer" to scheme.onSecondaryContainer,
        "tertiary" to scheme.tertiary,
        "onTertiary" to scheme.onTertiary,
        "tertiaryContainer" to scheme.tertiaryContainer,
        "onTertiaryContainer" to scheme.onTertiaryContainer,
        "background" to scheme.background,
        "onBackground" to scheme.onBackground,
        "surface" to scheme.surface,
        "onSurface" to scheme.onSurface,
        "surfaceVariant" to scheme.surfaceVariant,
        "onSurfaceVariant" to scheme.onSurfaceVariant,
        "surfaceTint" to scheme.surfaceTint,
        "inverseSurface" to scheme.inverseSurface,
        "inverseOnSurface" to scheme.inverseOnSurface,
        "error" to scheme.error,
        "onError" to scheme.onError,
        "errorContainer" to scheme.errorContainer,
        "onErrorContainer" to scheme.onErrorContainer,
        "outline" to scheme.outline,
        "outlineVariant" to scheme.outlineVariant,
        "scrim" to scheme.scrim
    )
}

